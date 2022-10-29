package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Service
public class BookService implements IBookService{
    @Autowired
    BookRepo bookRepo;

    // create a method name as add book

    /**
     *
     * @param bookDTO
     * @return Saved Information
     */
    public Book addBook(BookDto bookDTO) {
        Book addData = new Book(bookDTO);
        return bookRepo.save(addData);
    }
    //  create a method name as findall()

    /**
     *
     * @return List of Books
     */
    @Override
    public List<Book> findAll() {
        List<Book> bookList = bookRepo.findAll();
        return bookList;
    }
    // create a method name as findbyId

    /**
     *
     * @param id
     * @return Required Book
     */
    @Override
    public Book FindById(int id) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            return book;
        }
        return null;
    }
    //create a method name as gdeleteByid

    /**
     *
     * @param id
     * @return String of deleted Info
     */
    @Override
    public String deleteById(int id) {
        Book findById = bookRepo.findById(id).orElse(null);

        if (findById != null) {
            bookRepo.deleteById(id);
            return "data is deleted";

        }
        return null;
    }
    // create a method name as updateBookData

    /**
     *
     * @param id
     * @param bookdto
     * @return Book Details after edited
     */
    @Override
    public Book updateBookData(int id, BookDto bookdto) {
        Book editbook = bookRepo.findById(id).orElse(null);
        if (editbook != null) {
            editbook.setBookName(bookdto.getBookName());
            editbook.setBookAuthor(bookdto.getBookAuthor());
            editbook.setBookDesc(bookdto.getBookDesc());
            editbook.setBookPrice(bookdto.getBookPrice());
            editbook.setBookQuantity(bookdto.getBookQuantity());

            return bookRepo.save(editbook);
        }
    return null;
    }
}
