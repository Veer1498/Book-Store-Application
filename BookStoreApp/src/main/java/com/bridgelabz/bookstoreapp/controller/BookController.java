package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;
    // add book
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addBook(@RequestBody BookDto bookDTO) {
        Book book = bookService.addBook(bookDTO);
        ResponseDto responseDTO = new ResponseDto("Add Book  Success", book);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //  Ability to get all book data by findAll() method
    @GetMapping("/findAll")
    public ResponseEntity<ResponseDto> findAllDetail() {
        List<Book> userList = bookService.findAll();
        ResponseDto responseDTO = new ResponseDto("** All book List ** ", userList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //Ability to get book data by id
    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDto> FindById(@PathVariable int bookId) {
        Book response = bookService.FindById(bookId);
        ResponseDto responseDto = new ResponseDto("***All Details book list using Id***", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // Ability to delete book data for particular id
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        ResponseDto reponseDTO = new ResponseDto("**book Data deleted successfully ** ", "deleted id " + bookId);
        return new ResponseEntity(reponseDTO, HttpStatus.ACCEPTED);
    }
    //Ability to update book data for particular id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> editData(@PathVariable int bookid, @RequestBody BookDto bookDTO) {
        Book bookData = bookService.updateBookData(bookid, bookDTO);
        ResponseDto responseDTO = new ResponseDto("Updated Book Details Successfully", bookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
