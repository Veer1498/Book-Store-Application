package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total_price")
    private int totalPrice;

//    private int userId;
//    private int bookId;

    public Cart(User user , Book book,int cartPrice, CartDto cartDto) {
        this.user = user;
        this.book = book;
        this.quantity = cartDto.getQuantity();
        this.totalPrice = cartPrice;
    }
}
