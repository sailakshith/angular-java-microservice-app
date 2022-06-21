package com.capstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api_emp")
public class HomeController {

    @RequestMapping("/")
    public String welcome(){
        return "Welcome to User Service";
    }
}
