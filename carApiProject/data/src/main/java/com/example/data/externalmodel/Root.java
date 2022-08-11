package com.example.data.externalmodel;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Root {
    public Make make;
    public Model model;
    public Engine engine;
    public Transmission transmission;
    public String drivenWheels;
    public String numOfDoors;
    public ArrayList<Option> options;
    public ArrayList<Color> colors;
    public Price price;
    public Categories categories;
    public String squishVin;
    public ArrayList<Year> years;
    public String matchingType;
    public Mpg mpg;
}
