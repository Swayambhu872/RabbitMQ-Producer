package com.rabbitmq.demo.producer.rabbitmqProducer.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
