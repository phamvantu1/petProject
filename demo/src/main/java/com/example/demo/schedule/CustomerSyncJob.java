package com.example.demo.schedule;

import com.example.demo.service.RedisLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerSyncJob {

    @Autowired
    private RedisLockService lockService;

    @Scheduled(fixedRate  = 60000)
    public void syncCustomer() {

        String lockKey = "sync_customer_lock";

        String lockValue = UUID.randomUUID().toString();

        boolean locked = lockService.tryLock(
                lockKey,
                lockValue,
                300
        );

        if (!locked) {
            System.out.println("Another node is running");
            return;
        }

        try {

            System.out.println("Start sync");

            Thread.sleep(600000);

            System.out.println("Done sync");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockService.unlock(lockKey);
        }
    }
}