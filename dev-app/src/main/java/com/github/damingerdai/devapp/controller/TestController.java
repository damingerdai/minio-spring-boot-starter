package com.github.damingerdai.devapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Dev App is running!";
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}