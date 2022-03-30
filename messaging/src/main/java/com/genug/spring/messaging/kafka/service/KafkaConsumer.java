package com.genug.spring.messaging.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "kafka-demo", groupId = "kafka-demo")
    public void consume(String message) {
        log.info("Consumed message : {}", message);
    }
}
