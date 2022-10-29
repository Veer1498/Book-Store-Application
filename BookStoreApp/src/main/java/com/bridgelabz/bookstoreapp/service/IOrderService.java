package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.bridgelabz.bookstoreapp.model.Order;

import java.util.List;

public interface IOrderService {

    Order placeOrder(int userId, OrderDto orderDto);

    String cancelOrder(int orderId, int userId);

    List<Order> userOrders(int userId);
}
