package br.com.microserviceproducer.modules.shipping;

import br.com.microserviceproducer.modules.rabbitmq.producer.RabbitMqProducer;
import br.com.microserviceproducer.modules.shipping.request.ShippingRequest;
import br.com.microserviceproducer.modules.shipping.request.ShippingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/shipping"})
@RequiredArgsConstructor
public class ShippingController {

    private final RabbitMqProducer rabbitMqProducer;

    @PostMapping
    public ResponseEntity<ShippingResponse> sendQueue(@RequestBody ShippingRequest shippingRequest){
        ShippingResponse shippingResponse = rabbitMqProducer.sendQueueShipping(shippingRequest);
        return new ResponseEntity<>(shippingResponse, HttpStatus.OK);
    }
}
