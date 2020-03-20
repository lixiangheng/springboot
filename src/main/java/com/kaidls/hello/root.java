package com.kaidls.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class root {
    @GetMapping("/")
    public String root() {
        return "Hello, world! 2020 加油吧,这有有次更新哦";
    }

}

