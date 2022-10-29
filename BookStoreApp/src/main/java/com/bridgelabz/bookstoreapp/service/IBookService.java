package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import com.bridgelabz.bookstoreapp.model.Book;

import java.util.List;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
public interface IBookService {
    Book addBook(BookDto bookDTO);

    List<Book> findAll();

    Book FindById(int bookid);

    String deleteById(int bookid);

    Book updateBookData(int id, BookDto bookDTO);
}
