package com.zhy.dao;

import com.zhy.pojo.Order;
import com.zhy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}