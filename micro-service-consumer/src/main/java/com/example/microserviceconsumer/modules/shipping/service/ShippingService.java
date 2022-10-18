package com.example.microserviceconsumer.modules.shipping.service;

import com.example.microserviceconsumer.modules.shipping.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingService {

    private final ShippingRepository shippingRepository;
}
