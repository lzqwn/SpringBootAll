package com.springboot.springbootexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public void hello(){
        throw new RuntimeException("hello RuntimeException~");
    }

    @GetMapping("/hello2")
    public void hello2() {
        throw new RuntimeException();
    }
}
