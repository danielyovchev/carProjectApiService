package com.example.rest.controller;

import com.example.api.model.CarApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/carInfo")
    public CarApiResponse getCar(@RequestParam String vin){
        return null;
    }
}
