package br.com.microserviceproducer.order.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest implements Serializable {
    private Long id;
}

