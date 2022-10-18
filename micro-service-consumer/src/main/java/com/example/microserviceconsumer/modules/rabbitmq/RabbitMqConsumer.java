package com.example.microserviceconsumer.modules.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class RabbitMqConsumer {

    @RabbitListener(queues = "queue-order")
    public String receiveOrder(String message) {
        log.info("Message received: {}", message);
        return message;
    }

    @RabbitListener(queues = "queue-payment")
    public String receivePayment(String message) {
        log.info("Message received: {}", message);
        return message;
    }

    @RabbitListener(queues = "queue-shipping")
    public String receiveShipping(String message) {
        log.info("Message received: {}", message);
        return message;
    }

}
