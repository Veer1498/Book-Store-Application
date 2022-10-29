package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query(value = "select * from orders where user_id = :userId", nativeQuery = true)

    List<Order> findAllByUserId(int userId);
}
