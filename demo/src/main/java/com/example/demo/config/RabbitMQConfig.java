package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "demo.exchange";

    public static final String QUEUE_1 = "queue.email";
    public static final String QUEUE_2 = "queue.sms";

    public static final String ROUTING_EMAIL = "routing.email";
    public static final String ROUTING_SMS = "routing.sms";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(QUEUE_1);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(QUEUE_2);
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder
                .bind(emailQueue())
                .to(exchange())
                .with(ROUTING_EMAIL);
    }

    @Bean
    public Binding smsBinding() {
        return BindingBuilder
                .bind(smsQueue())
                .to(exchange())
                .with(ROUTING_SMS);
    }
}