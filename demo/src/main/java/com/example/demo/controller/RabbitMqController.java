package com.example.demo.controller;

import com.example.demo.dto.NotificationMessage;
import com.example.demo.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RabbitMqController {

    private final MessageProducer producer;

    @GetMapping("/push")
    public String push() {

        for (int i = 1; i <= 1000; i++) {

            NotificationMessage email = new NotificationMessage(
                    (long) i,
                    "EMAIL",
                    "Email content " + i
            );

            NotificationMessage sms = new NotificationMessage(
                    (long) i,
                    "SMS",
                    "SMS content " + i
            );

            producer.sendEmail(email);
            producer.sendSms(sms);
        }

        return "DONE";
    }
}
