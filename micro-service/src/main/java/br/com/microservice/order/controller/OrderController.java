package br.com.microservice.order.controller;

import br.com.microservice.order.request.OrderRequest;
import br.com.microservice.order.request.OrderResponse;
import br.com.microservice.rabbitmq.producer.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/order"})
@RequiredArgsConstructor
public class OrderController {

    private final RabbitMqProducer rabbitMqProducer;

    @PostMapping
    public ResponseEntity<OrderResponse> sendQueue(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = rabbitMqProducer.sendQueueOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
