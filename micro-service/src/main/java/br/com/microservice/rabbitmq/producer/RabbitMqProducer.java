package br.com.microservice.rabbitmq.producer;

import br.com.microservice.order.request.OrderRequest;
import br.com.microservice.order.request.OrderResponse;
import br.com.microservice.payment.request.PaymentRequest;
import br.com.microservice.payment.request.PaymentResponse;
import br.com.microservice.shipping.request.ShippingRequest;
import br.com.microservice.shipping.request.ShippingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMqProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue.order}")
    private String ORDER_QUEUE;
    @Value("${spring.rabbitmq.queue.payment}")
    private String PAYMENT_QUEUE;
    @Value("${spring.rabbitmq.queue.shipping}")
    private String SHIPPING_QUEUE;

    public OrderResponse sendQueueOrder(OrderRequest orderRequest){
        rabbitTemplate.convertAndSend(ORDER_QUEUE, orderRequest);
        return OrderResponse.builder().build();
    }

    public PaymentResponse sendQueuePayment(PaymentRequest paymentRequest){
        rabbitTemplate.convertAndSend(PAYMENT_QUEUE, paymentRequest);
        return PaymentResponse.builder().build();
    }

    public ShippingResponse sendQueueShipping(ShippingRequest shippingRequest){
        rabbitTemplate.convertAndSend(SHIPPING_QUEUE, shippingRequest);
        return ShippingResponse.builder().build();
    }
}
