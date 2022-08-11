package com.example.core.interfaces;

import com.example.api.model.CarApiResponse;

public interface CarApiService {
    CarApiResponse getCar(String vin);
}
