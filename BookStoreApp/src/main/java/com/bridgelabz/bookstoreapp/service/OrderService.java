package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.model.Order;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.repository.BookRepo;
import com.bridgelabz.bookstoreapp.repository.CartRepo;
import com.bridgelabz.bookstoreapp.repository.OrderRepo;
import com.bridgelabz.bookstoreapp.repository.UserRepo;
import com.bridgelabz.bookstoreapp.utilities.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    MailService mailService;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    BookRepo bookRepo;

    @Override
    public Order placeOrder(int userId, OrderDto orderDto) {
        User user = userRepo.findById(userId).orElse(null);
        Book book = bookRepo.findById(orderDto.getBookId()).orElse(null);
        if (user != null) {

            //Price Calculations
            int orderPrice = book.getBookPrice() * orderDto.getQuantity();

            //Remove Quantity of Books after Order Placed
            book.setBookQuantity(book.getBookQuantity()-orderDto.getQuantity());
            Order order = new Order(user,book,orderPrice,orderDto);
            orderRepo.save(order);

            //Delete Cart By Id
            cartRepo.deleteById(orderDto.getCartId());

            //Order Successful Mail
            mailService.sendEmail(user.getEmailId(),
                    "Your Order was Successfully Placed",
                    "Order Placed with Given Details \n"
                            +"Book Name :"+order.getBook().getBookName()+"\n"
                            +"Book Description :"+order.getBook().getBookDesc()+"\n"
                            +"Book Price :"+order.getBook().getBookPrice()+"\n"
                            +"Order Quantity :"+orderDto.getQuantity()
                            +"\n"+"Order Price :"+orderPrice);
            return order;
        }
        return null;
    }

    @Override
    public String cancelOrder(int orderId, int userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            Order order = orderRepo.findById(orderId).orElse(null);
            Book book = bookRepo.findById(order.getBook().getBookId()).orElse(null);

            if (order != null) {
                order.setCancel(true);
                orderRepo.save(order);

                //To Change Quantity after Calcellation of Order
                book.setBookQuantity(book.getBookQuantity() + order.getQuantity());

                //Cancel Mail
                mailService.sendEmail(user.getEmailId(),"Your Order Was Successfully Cancelled","Order was Cancelled with below ID\nOrder Id:"+orderId);
                return "Order Cancelled";
            }
        }
        return "cancel Function Stopped";
    }

    @Override
    public List<Order> userOrders(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            List<Order> order = orderRepo.findAllByUserId(userId);
            return order;
        }
        return null;
    }


}
