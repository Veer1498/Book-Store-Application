package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate orderDate;
    private int quantity;
    private String address;

    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "book_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    private boolean cancel = false;
    private int orderPrice;


    public Order(User user, Book book,int orderPrice, OrderDto orderDto) {
        this.orderDate = LocalDate.now();
        this.quantity = orderDto.getQuantity();
        this.address = orderDto.getAddress();
        this.orderPrice = orderPrice;
        this.user = user;
        this.book = book;
    }
}
