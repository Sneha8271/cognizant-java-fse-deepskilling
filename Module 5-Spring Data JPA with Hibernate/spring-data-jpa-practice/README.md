# Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)
- JSR 338 specification for persisting, reading, and managing Java objects as relational data.
- It is only a specification -- it has no concrete implementation.

## Hibernate
- An ORM tool that implements the JPA specification.
- Handles the actual mapping between Java objects and database tables.

## Spring Data JPA
- Does not implement JPA itself, but sits on top of a JPA provider (like Hibernate).
- Reduces boilerplate code (no manual Session/Transaction handling).
- Manages transactions declaratively via @Transactional.

## Code comparison

Hibernate (manual):
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    session.save(employee);
    tx.commit();
    session.close();

Spring Data JPA (declarative):
    public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
