package com.example.microserviceconsumer.modules.shipping.repository;

import com.example.microserviceconsumer.modules.shipping.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
