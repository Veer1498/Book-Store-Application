package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
}
