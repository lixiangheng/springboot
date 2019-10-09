package com.kaidls.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class root {
    @GetMapping("/")
    public String root() {
        return "Hello, 这是主页，20191009";
    }

}

