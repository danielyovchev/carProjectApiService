package com.example.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter @Builder
public class CarApiResponse {
    private List<CarApiResponseModel> carApiResponseModelList;
}
