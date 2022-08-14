package com.example.api.feign;

import com.example.api.model.CarApiResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "apiProjectFeignClient", url = "http://localhost:8083")
public interface ApiFeignClient {
    @GetMapping("/carInfo")
    CarApiResponseModel getCar(@RequestParam String vin);
}
