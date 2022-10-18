package com.example.microserviceconsumer.modules.payment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper {
    public static final PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
}
