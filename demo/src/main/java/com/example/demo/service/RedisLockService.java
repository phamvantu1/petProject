package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisLockService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean tryLock(String key,
                           String value,
                           long timeoutSeconds) {

        Boolean success = redisTemplate.opsForValue()
                .setIfAbsent(
                        key,
                        value,
                        Duration.ofSeconds(timeoutSeconds)
                );

        return Boolean.TRUE.equals(success);
    }

    public void unlock(String key) {
        redisTemplate.delete(key);
    }
}
