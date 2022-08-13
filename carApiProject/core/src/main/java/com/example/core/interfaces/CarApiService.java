package com.example.core.interfaces;

import com.example.api.model.CarApiResponse;
import com.example.api.model.CarApiResponseModel;

public interface CarApiService {
    CarApiResponseModel getCar(String vin);
}
