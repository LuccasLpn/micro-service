package br.com.microserviceproducer.modules.payment.request;

import br.com.microserviceproducer.modules.enums.PaymentEnum;
import br.com.microserviceproducer.modules.order.request.OrderRequest;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest implements Serializable {
    private Long id;
    private PaymentEnum paymentEnum;
    private OrderRequest order;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}

