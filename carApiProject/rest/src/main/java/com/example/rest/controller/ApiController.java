package com.example.rest.controller;

import com.example.api.model.CarApiResponseModel;
import com.example.core.interfaces.CarApiProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final CarApiProcessor carApiProcessor;

    public ApiController(CarApiProcessor carApiProcessor) {
        this.carApiProcessor = carApiProcessor;
    }

    @GetMapping("/carInfo")
    public CarApiResponseModel getCar(@RequestParam String vin){
        return carApiProcessor.getCar(vin);
    }
}
