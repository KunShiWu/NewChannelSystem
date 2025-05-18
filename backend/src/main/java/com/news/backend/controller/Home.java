package com.news.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Home {
    @GetMapping("/")
    private String info()
    {
        return  "test";
    }

}
