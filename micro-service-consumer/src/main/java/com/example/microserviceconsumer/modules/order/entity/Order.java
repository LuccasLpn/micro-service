package com.example.microserviceconsumer.modules.order.entity;

import com.example.microserviceconsumer.modules.converter.ProductConverter;
import com.example.microserviceconsumer.modules.order.dto.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tb_order")
public class Order implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_order_seq")
    @SequenceGenerator(name = "tb_order_seq", sequenceName = "tb_order_seq", allocationSize = 1)
    private Long id;

    @Column(name = "product", columnDefinition = "text")
    @Convert(converter = ProductConverter.class)
    private Product product;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

}
