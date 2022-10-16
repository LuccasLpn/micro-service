package br.com.microservice.shipping.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingRequest implements Serializable {
    private Long id;
}
