package com.example.microserviceconsumer.modules.payment.entity;

import com.example.microserviceconsumer.modules.enums.PaymentEnum;
import com.example.microserviceconsumer.modules.order.entity.Order;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tb_payment")
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_payment_seq")
    @SequenceGenerator(name = "tb_payment_seq", sequenceName = "tb_payment_seq", allocationSize = 1)
    private Long id;

    @Column(name = "payment_enum")
    private PaymentEnum paymentEnum;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;
}
