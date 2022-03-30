package com.genug.spring.messaging.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 5000)
    public void send() {
        rabbitTemplate.convertAndSend("work", "hello");
    }
}
