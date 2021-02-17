package org.example.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver implements MessageListener {

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "${javainuse.rabbitmq.queue}", durable = "false"),
            exchange = @Exchange(value = "${javainuse.rabbitmq.exchange}", type = ExchangeTypes.DIRECT, durable = "true")
    )
    )
    @Override
    public void onMessage(Message message) {
        System.out.println("Received message:" + message.toString());
    }
}