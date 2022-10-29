package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

    @Query(value = "select * from cart where userid=:id", nativeQuery = true)
    List<Cart> getCartListByUserId(int id);
}
