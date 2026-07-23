package com.cognizant.springcore.repository;

public class BookRepository {
    public String findBookById(int id) {
        return "Book with ID " + id + " fetched from repository.";
    }
}
