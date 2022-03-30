package com.genug.spring.messaging.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Slf4j
@Component
public class Receiver {

    // 동일한

    @RabbitListener(queues = "work")
    public void reiceveGray(final Message message) {
        log.info("1");
        // log.info("1 --- called body message : {}", message.getBody());
    }

    @RabbitListener(queues = "work")
    public void reiceveNavy(final Message message) {
        log.info("2");
        //log.info("2 --- called body message : {}", message.getBody());
    }

    @RabbitListener(queues = "work")
    public void reiceveOrange(final Message message) {
        log.info("3");
        // log.info("3 --- called body message : {}", message.getBody());
    }
}
