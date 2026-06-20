package com.example.demo.consumer;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.dto.NotificationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_2)
    public void consume(NotificationMessage message) throws InterruptedException {

        log.info("SMS CONSUMER: {}", message);

        Thread.sleep(1000);
    }
}
