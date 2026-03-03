package com.example.CloudGateWay.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/orderServiceFallback")
    public String OrderServiceFallback() {
        return "Order Service is not working!!";
    }

    @GetMapping("/productServiceFallback")
    public String ProductServiceFallback() {
        return "Product Service is not working!!";
    }
}

