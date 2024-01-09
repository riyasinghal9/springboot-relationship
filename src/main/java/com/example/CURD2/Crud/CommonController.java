package com.example.CURD2.Crud;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mapping")
public class CommonController {

    @PostMapping("/user-order-mapping")
    public String mappingUser() {
        // System.out.println("Hi");

        return "HI";
    }
    
}