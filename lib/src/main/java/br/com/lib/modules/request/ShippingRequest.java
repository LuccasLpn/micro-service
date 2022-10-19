package br.com.lib.modules.request;

import br.com.lib.modules.enums.ShippingEnum;
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
