package com.rabbitmq.demo.producer.rabbitmqProducer.controller;

import com.rabbitmq.demo.producer.rabbitmqProducer.dto.User;
import com.rabbitmq.demo.producer.rabbitmqProducer.publisher.RabbitMQJSONProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final RabbitMQJSONProducer rabbitMQJSONProducer;

    public UserController(RabbitMQJSONProducer rabbitMQJSONProducer) {
        this.rabbitMQJSONProducer = rabbitMQJSONProducer;
    }


    @PostMapping("/user")
    public ResponseEntity<String> publishUser(@RequestBody User user) {
        rabbitMQJSONProducer.sendMessage(user);
        return ResponseEntity.ok("Json message Sent");
    }
}
