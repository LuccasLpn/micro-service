package com.example.microserviceconsumer.modules.converter;

import br.com.lib.modules.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductConverter implements AttributeConverter<Product, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Product attribute) {
        if (attribute == null) return null;
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public Product convertToEntityAttribute(String dbData) {
        if (dbData.isBlank()) return null;
        return objectMapper.readValue(dbData, Product.class);
    }

}
