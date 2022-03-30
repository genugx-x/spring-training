package com.genug.spring.messaging.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigurer {

    @Bean
    public Queue queue() {
        return new Queue("work");
    }

}
