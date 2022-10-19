package br.com.lib.modules.request;

import br.com.lib.modules.enums.PaymentEnum;
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

