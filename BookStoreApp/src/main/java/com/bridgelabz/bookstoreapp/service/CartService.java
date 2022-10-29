package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.model.Cart;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.repository.BookRepo;
import com.bridgelabz.bookstoreapp.repository.CartRepo;
import com.bridgelabz.bookstoreapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Service
public class CartService implements ICartService{
@Autowired
    CartRepo cartRepo;

@Autowired
    UserRepo userRepo;

@Autowired
    BookRepo bookRepo;

@Autowired
IUserService userService;

@Autowired
IBookService bookService;
    @Override
    public Cart addToCart(int userId, CartDto cartDto) {
        User user = userRepo.findById(userId).orElse(null);
        Book book = bookService.FindById(cartDto.getBookId());
        if(user != null && book != null){
            int cartPrice = book.getBookPrice() * cartDto.getQuantity();
            Cart cart = new Cart(user,book,cartPrice,cartDto);
            return cartRepo.save(cart);
        }
        return null;
    }

    @Override
    public String deleteById(int cartid) {
        Optional<Cart> cart = cartRepo.findById(cartid);
        if(cart != null) {
            cartRepo.deleteById(cartid);
            return "Cart Removed";
        }
        return null;
    }

    @Override
    public Cart changeCartQty(int userId, int cartId, CartDto cartDto) {
        User user = userRepo.findById(userId).orElse(null);
        Book book = bookRepo.findById(cartDto.getBookId()).orElse(null);
        Cart cart = cartRepo.findById(cartId).orElse(null);
        if(cart != null && user != null){
            if(book != null){
                cart.setBook(book);
                cart.setQuantity(cartDto.getQuantity());
                cart.setTotalPrice(book.getBookPrice() * cartDto.getQuantity());
                return cartRepo.save(cart);
            }
        }
        return null;
    }

    @Override
    public List<Cart> findAll() {
        List<Cart> cartList = cartRepo.findAll();
        return cartList;
    }

    @Override
    public List<Cart> getCartDetailsByUserId(int userId) {
        List<Cart> userCartList = cartRepo.getCartListByUserId(userId);
        if(userCartList.isEmpty()){
            return null;
        }else
            return userCartList;
    }
}
