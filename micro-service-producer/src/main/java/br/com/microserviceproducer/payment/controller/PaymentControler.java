package br.com.microserviceproducer.payment.controller;

import br.com.microserviceproducer.payment.request.PaymentRequest;
import br.com.microserviceproducer.payment.request.PaymentResponse;
import br.com.microserviceproducer.rabbitmq.producer.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/payment"})
@RequiredArgsConstructor
public class PaymentControler {
    private final RabbitMqProducer rabbitMqProducer;

    @PostMapping
    public ResponseEntity<PaymentResponse> sendQueue(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse paymentResponse = rabbitMqProducer.sendQueuePayment(paymentRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
