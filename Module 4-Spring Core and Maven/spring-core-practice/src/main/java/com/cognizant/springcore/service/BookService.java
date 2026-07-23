package com.cognizant.springcore.service;

import com.cognizant.springcore.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String getBookDetails(int id) {
        return bookRepository.findBookById(id);
    }
}
