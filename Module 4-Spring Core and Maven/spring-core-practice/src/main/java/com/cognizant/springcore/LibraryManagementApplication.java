package com.cognizant.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.springcore.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        BookService service = (BookService) context.getBean("bookService");
        System.out.println(service.getBookDetails(1));
    }
}
