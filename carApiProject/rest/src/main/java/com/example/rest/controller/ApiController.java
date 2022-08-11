package com.example.rest.controller;

import com.example.api.model.CarApiResponse;
import com.example.core.interfaces.CarApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final CarApiService carApiService;

    public ApiController(CarApiService carApiService) {
        this.carApiService = carApiService;
    }

    @GetMapping("/carInfo")
    public CarApiResponse getCar(@RequestParam String vin){
        return carApiService.getCar(vin);
    }
}
