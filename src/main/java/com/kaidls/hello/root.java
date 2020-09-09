package com.kaidls.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class root {
    @GetMapping("/")
    public String root() {
        return "Hello, world! 2020 加油吧,GOGOGO！2020.9.9日";
    }

}

