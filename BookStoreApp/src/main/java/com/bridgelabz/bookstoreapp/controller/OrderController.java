package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.model.Order;
import com.bridgelabz.bookstoreapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @PostMapping("/placeOrder/{userId}")
    public ResponseEntity<ResponseDto> placeOrder(@PathVariable("userId") int userId, @RequestBody OrderDto orderDto) {
        Order order = orderService.placeOrder(userId,orderDto);
        ResponseDto response= new ResponseDto("Your Order Has Placed Successfully ",  order.getId());
        return new ResponseEntity<> (response, HttpStatus.OK);
    }

    @PutMapping("/cancelOrder/{orderId}/{userId}")
    public ResponseEntity<ResponseDto> cancelOrder(@PathVariable int orderId,@PathVariable int userId) {
        String order = orderService.cancelOrder(orderId,userId);
        ResponseDto response= new ResponseDto("Cancelled Successfully ",  order);
        return new ResponseEntity<> (response,HttpStatus.OK);
    }

    @GetMapping("/userOrders/{userId}")
    public ResponseEntity<ResponseDto> getUserOrders(@PathVariable("userId") int userId){
        List<Order> userOrders = orderService.userOrders(userId);
        ResponseDto response = new ResponseDto("Orders of user ", userOrders);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
