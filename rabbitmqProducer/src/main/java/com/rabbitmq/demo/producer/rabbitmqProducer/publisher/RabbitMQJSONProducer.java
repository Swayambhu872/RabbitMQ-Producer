package com.rabbitmq.demo.producer.rabbitmqProducer.publisher;

import com.rabbitmq.demo.producer.rabbitmqProducer.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJSONProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJSONProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value(("${rabbitmq.json.routing.key}"))
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJSONProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info(String.format("Json message sent: %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
    }
}
