package com.genug.spring.messaging.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private static final String TOPIC = "kafka-demo"; // request에서 header, body(data), params 등 으로 가변적인 요소가 될 것
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Produce message : %s", message);
        this.kafkaTemplate.send(TOPIC, message);
    }

}
