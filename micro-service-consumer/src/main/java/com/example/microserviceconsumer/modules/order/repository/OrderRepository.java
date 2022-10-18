package com.example.microserviceconsumer.modules.order.repository;

import com.example.microserviceconsumer.modules.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
