package com.barber.controller;

import com.barber.entity.Customer;
import com.barber.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Define a base URI for your REST endpoints
@RequiredArgsConstructor
public class GlobalControllerAdvice {

    private final CustomerService customerService;

    @GetMapping("/isAdmin")
    public boolean isAdmin() {
        return customerService.isUserAdmin();
    }

    @GetMapping("/isUser")
    public boolean isUser() {
        return customerService.isUserUser();
    }

    @GetMapping("/user")
    public Customer getLoggedInUser() {
        return customerService.getLoggedInUser();
    }
}

