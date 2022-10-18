package com.example.microserviceconsumer.modules.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    private static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
