package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.model.Cart;

import java.util.List;

/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
public interface ICartService {

    Cart addToCart(int userId, CartDto cartDto);
    String deleteById(int cartid);

    Cart changeCartQty(int userId, int cartId, CartDto cartDto);

    List<Cart> findAll();

    List<Cart> getCartDetailsByUserId(int userId);
}
