package com.sneha.deepskilling;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A simple class under test — represents the "fixture" we test against.
 * In real projects this would live in its own file under src/main/java,
 * but for this exercise we keep it here for simplicity.
 */
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest {

    // This field is our "fixture" — the shared object each test operates on
    private BankAccount account;

    // Runs ONCE before all tests in this class (must be static)
    @BeforeAll
    static void setupClass() {
        System.out.println("Starting BankAccountTest suite...");
    }

    // Runs before EVERY test method — gives each test a fresh, clean fixture
    @BeforeEach
    void setUp() {
        // ARRANGE (shared part): every test starts with a fresh account with ₹1000
        account = new BankAccount(1000.0);
        System.out.println("New BankAccount created with balance 1000.0");
    }

    // Runs after EVERY test method — good for cleanup (closing files, DB connections etc.)
    @AfterEach
    void tearDown() {
        System.out.println("Test finished. Final balance was: " + account.getBalance());
    }

    // Runs ONCE after all tests are done
    @AfterAll
    static void tearDownClass() {
        System.out.println("BankAccountTest suite completed.");
    }

    @Test
    void depositIncreasesBalance() {
        // ARRANGE — done in setUp(), account already has 1000.0

        // ACT
        account.deposit(500.0);

        // ASSERT
        assertEquals(1500.0, account.getBalance(), "Balance should increase by deposit amount");
    }

    @Test
    void withdrawDecreasesBalance() {
        // ARRANGE — account has 1000.0 from setUp()

        // ACT
        account.withdraw(300.0);

        // ASSERT
        assertEquals(700.0, account.getBalance(), "Balance should decrease by withdrawal amount");
    }

    @Test
    void withdrawMoreThanBalanceThrowsException() {
        // ARRANGE — account has 1000.0

        // ACT + ASSERT (combined here because we're checking behavior on invalid action)
        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(5000.0);
        }, "Withdrawing more than balance should throw IllegalStateException");
    }

    @Test
    void depositNegativeAmountThrowsException() {
        // ARRANGE — account has 1000.0

        // ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        }, "Depositing a negative amount should throw IllegalArgumentException");
    }

    @Test
    void multipleDepositsAccumulateCorrectly() {
        // ARRANGE — account has 1000.0

        // ACT
        account.deposit(200.0);
        account.deposit(300.0);

        // ASSERT
        assertEquals(1500.0, account.getBalance(), "Balance should reflect sum of all deposits");
    }
}
