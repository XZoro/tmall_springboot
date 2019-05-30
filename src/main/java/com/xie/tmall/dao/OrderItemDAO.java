package com.xie.tmall.dao;

import com.xie.tmall.pojo.Order;
import com.xie.tmall.pojo.OrderItem;
import com.xie.tmall.pojo.Product;
import com.xie.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
