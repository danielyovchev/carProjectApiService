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
    private int year;
    private String fuel;
    private double economy;
    private int displacement;
    private int horsepower;
    private int torque;
    private String transmission;
    private int gears;
    private String drivenWheels;
}
