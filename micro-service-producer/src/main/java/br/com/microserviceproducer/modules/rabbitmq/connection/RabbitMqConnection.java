package br.com.microserviceproducer.modules.rabbitmq.connection;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMqConnection {

    private static final String NOME_EXCHANGE = "amq.direct";

    @Value("${spring.rabbitmq.queue.order}")
    private String ORDER_QUEUE;
    @Value("${spring.rabbitmq.queue.payment}")
    private String PAYMENT_QUEUE;
    @Value("${spring.rabbitmq.queue.shipping}")
    private String SHIPPING_QUEUE;
    private final AmqpAdmin amqpAdmin;

    public RabbitMqConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }

    @PostConstruct
    private void adiciona(){
        Queue fileOrder = this.fila(ORDER_QUEUE);
        Queue filePayment = this.fila(PAYMENT_QUEUE);
        Queue fileShipping = this.fila(SHIPPING_QUEUE);
        DirectExchange troca = this.trocaDireta();
        Binding ligacaoOrder = this.relacionamento(fileOrder, troca);
        Binding ligacaoPayment = this.relacionamento(filePayment, troca);
        Binding ligacaoShipping = this.relacionamento(fileShipping, troca);
        this.amqpAdmin.declareQueue(fileOrder);
        this.amqpAdmin.declareQueue(filePayment);
        this.amqpAdmin.declareQueue(fileShipping);
        this.amqpAdmin.declareExchange(troca);
        this.amqpAdmin.declareBinding(ligacaoOrder);
        this.amqpAdmin.declareBinding(ligacaoPayment);
        this.amqpAdmin.declareBinding(ligacaoShipping);
    }
}
