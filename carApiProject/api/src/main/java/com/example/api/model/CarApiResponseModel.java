package com.example.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
public class CarApiResponseModel {
    private String vin;
    private String make;
    private String model;
    private Integer year;
    private String fuel;
    private Double economy;
    private Integer displacement;
    private Integer horsepower;
    private Integer torque;
    private String transmission;
    private Integer gears;
    private String drivenWheels;
}
