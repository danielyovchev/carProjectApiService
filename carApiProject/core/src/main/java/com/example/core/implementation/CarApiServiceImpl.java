package com.example.core.implementation;

import com.example.api.model.CarApiResponse;
import com.example.api.model.CarApiResponseModel;
import com.example.core.exception.CarNotFoundException;
import com.example.core.interfaces.CarApiService;
import com.example.core.interfaces.RestTemplateProvider;
import com.example.data.externalmodel.Root;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarApiServiceImpl implements CarApiService {
    private final RestTemplateProvider restTemplateProvider;

    public CarApiServiceImpl(RestTemplateProvider restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
    }

    @Override
    public CarApiResponseModel getCar(String vin) {
        final String url = "https://auto.dev/api/vin/"+vin+"?apikey=ZrQEPSkKZGFuaWVseW92Y2hldkBnbWFpbC5jb20=";
        Root root = Objects.requireNonNull(restTemplateProvider.getRestTemplate().getForObject(url, Root.class));
        final double convertParam = 235.214;
        try {
            return CarApiResponseModel.builder()
                    .vin(vin)
                    .make(root.make.name)
                    .model(root.model.name)
                    .year(root.years.get(0).year)
                    .fuel(root.engine.fuelType)
                    .economy((convertParam/Double.parseDouble((root.mpg.city))+convertParam/Double.parseDouble(root.mpg.highway))/2)
                    .horsepower(root.engine.horsepower)
                    .displacement(root.engine.displacement)
                    .torque(root.engine.torque)
                    .transmission(root.transmission.transmissionType)
                    .gears(Integer.parseInt(root.transmission.numberOfSpeeds))
                    .drivenWheels(root.drivenWheels)
                    .build();
        }
        catch (Exception e){
            throw new CarNotFoundException();
        }
    }
}
