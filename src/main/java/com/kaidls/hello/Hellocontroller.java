package com.kaidls.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class Hellocontroller {
    @GetMapping("/hello")
    public String hello() {
        return "This is uri /hello, new20191009";
    }
}

