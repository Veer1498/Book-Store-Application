package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from users WHERE email_id= :Email", nativeQuery = true)
    User findByEmail(String Email);
}
