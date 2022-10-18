package com.example.microserviceconsumer.modules.shipping.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ShippingMapper {

    public static final ShippingMapper INSTANCE = Mappers.getMapper(ShippingMapper.class);
}
