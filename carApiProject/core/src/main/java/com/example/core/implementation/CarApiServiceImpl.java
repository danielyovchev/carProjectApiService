package com.example.core.implementation;

import com.example.api.model.CarApiResponse;
import com.example.core.exception.CarNotFoundException;
import com.example.core.interfaces.CarApiService;
import com.example.core.interfaces.RestTemplateProvider;
import com.example.data.externalmodel.Root;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarApiServiceImpl implements CarApiService {
    private final RestTemplateProvider restTemplateProvider;

    public CarApiServiceImpl(RestTemplateProvider restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
    }

    @Override
    public CarApiResponse getCar(String vin) {
        final String url = "https://auto.dev/api/vin/"+vin+"?apikey=ZrQEPSkKZGFuaWVseW92Y2hldkBnbWFpbC5jb20=";
        Root root = Objects.requireNonNull(restTemplateProvider.getRestTemplate().getForObject(url, Root.class));
        try {
            return CarApiResponse.builder().make(root.make.name)
                    .model(root.model.name)
                    .horsepower(root.engine.horsepower)
                    .colour(root.colors.get(1).options.get(1).name)
                    .displacement(root.engine.displacement)
                    .build();
        }
        catch (Exception e){
            throw new CarNotFoundException();
        }
    }
}
