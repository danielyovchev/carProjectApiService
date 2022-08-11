package com.example.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
public class CarApiResponse {
    private String make;
    private String model;
    private int displacement;
    private int horsepower;
    private String colour;
}
