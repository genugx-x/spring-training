package com.genug.spring.messaging.kafka.controller;

import com.genug.spring.messaging.kafka.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        this.producer.sendMessage(message);
        return "success";
    }

}