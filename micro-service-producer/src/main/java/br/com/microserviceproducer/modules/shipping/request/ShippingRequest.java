package br.com.microserviceproducer.modules.shipping.request;

import br.com.microserviceproducer.modules.enums.ShippingEnum;
import br.com.microserviceproducer.modules.order.request.OrderRequest;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingRequest implements Serializable {
    private Long id;
    private ShippingEnum shippingEnum;
    private OrderRequest order;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
