package com.example.data.externalmodel;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Option {
    public String category;
    public ArrayList<Option> options;
    public String id;
    public String name;
    public String equipmentType;
    public String availability;
    public String description;
}
