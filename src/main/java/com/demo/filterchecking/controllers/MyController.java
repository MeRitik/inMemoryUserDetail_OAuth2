package com.demo.filterchecking.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public ResponseEntity<String> get(HttpServletRequest request) {
        String welcomeMessage = "Hello World";
        String user = (String) request.getAttribute("user");
        System.out.println(user);
        if(user != null) {
            welcomeMessage += " " + user;
        }
        return ResponseEntity.ok(welcomeMessage);
    }
}
