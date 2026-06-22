package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;
    private final ObjectMapper objectMapper;


    @PostMapping
    public String save() throws JsonProcessingException {

        UserDto user = new UserDto(
                1L,
                "Pham Tu"
        );
        String json =
                objectMapper.writeValueAsString(user);

        redisService.saveWithExpire(
                "user:1",
                json,
                60
        );

        return "saved";
    }

    @GetMapping
    public Object get() {
        return redisService.get("user:1");
    }
}
