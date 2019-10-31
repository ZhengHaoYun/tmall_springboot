package com.zhy.dao;

import com.zhy.pojo.Order;
import com.zhy.pojo.OrderItem;
import com.zhy.pojo.Product;
import com.zhy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUser(User user);
}