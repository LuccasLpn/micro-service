package com.example.microserviceconsumer.modules.shipping.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tb_shipping")
public class Shipping {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_shipping_seq")
    @SequenceGenerator(name = "tb_shipping_seq", sequenceName = "tb_shipping_seq", allocationSize = 1)
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;
}
