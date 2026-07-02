package com.sneha.deepskilling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class AssertionsExerciseTest {

    // 1. assertEquals - checks two values are equal
    @Test
    void testAssertEquals() {
        int actual = 10 + 20;
        assertEquals(30, actual, "10 + 20 should equal 30");
    }

    // 2. assertNotEquals - checks two values are NOT equal
    @Test
    void testAssertNotEquals() {
        int actual = 10 + 20;
        assertNotEquals(25, actual, "10 + 20 should not equal 25");
    }

    // 3. assertTrue / assertFalse - checks boolean conditions
    @Test
    void testAssertTrueFalse() {
        int age = 20;
        assertTrue(age >= 18, "Age should be 18 or above");
        assertFalse(age < 18, "Age should not be below 18");
    }

    // 4. assertNull / assertNotNull - checks for null values
    @Test
    void testAssertNullNotNull() {
        String name = null;
        String greeting = "Hello Sneha";

        assertNull(name, "Name should be null");
        assertNotNull(greeting, "Greeting should not be null");
    }

    // 5. assertArrayEquals - checks two arrays have the same content
    @Test
    void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    // 6. assertThrows - checks that a specific exception is thrown
    @Test
    void testAssertThrows() {
        // Dividing by zero should throw ArithmeticException
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    int result = 10 / 0;
                }
        );
        assertEquals("/ by zero", exception.getMessage());
    }

    // 7. assertAll - groups multiple assertions; ALL are checked
    // even if one fails, giving you a full report instead of stopping at the first failure
    @Test
    void testAssertAll() {
        String firstName = "Sneha";
        String lastName = "Singh";

        assertAll("nameCheck",
                () -> assertEquals("Sneha", firstName),
                () -> assertEquals("Singh", lastName),
                () -> assertTrue(firstName.length() > 0)
        );
    }

    // 8. assertEquals with collections
    @Test
    void testListEquals() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = Arrays.asList(1, 2, 3);
        assertEquals(expected, actual, "Lists should have the same elements in order");
    }

    // 9. assertTimeout - checks code finishes within a time limit
    @Test
    void testAssertTimeout() {
        assertTimeout(java.time.Duration.ofMillis(100), () -> {
            // simulate quick task
            Thread.sleep(10);
        });
    }
}
