package com.example.core.interfaces;

import com.example.api.model.CarApiResponseModel;

public interface CarApiProcessor {
    CarApiResponseModel getCar(String vin);
}
