package com.example.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "apiProjectFeign", url = "http://localhost:8082")
public interface ApiFeignClient {
    @GetMapping("/createCar")
    String getVin(@RequestParam String vin);
}
