package com.example.core.implementation;

import com.example.api.model.CarApiResponseModel;
import com.example.core.exception.CarNotFoundException;
import com.example.core.interfaces.CarApiService;
import com.example.core.interfaces.RestTemplateProvider;
import com.example.data.externalmodel.Root;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

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
            Double kml = (convertParam/Double.parseDouble(root.mpg.city)+convertParam/Double.parseDouble(root.mpg.highway))/2;
            String transmissionType = root.transmission.transmissionType;
            Integer gearsNum = Integer.parseInt(root.transmission.numberOfSpeeds);
            String drivenWheels = root.drivenWheels;
            if(root.mpg.city == null || root.mpg.highway == null){
                kml = new Random().nextDouble() * (15.0 - 7.0) + 7.0;
            }
            if(transmissionType.isEmpty()){
                transmissionType = "Manual";
            }
            if(gearsNum == null){
                gearsNum = 6;

            }
            if(drivenWheels.isEmpty()){
                drivenWheels = "rear wheel drive";
            }
            return CarApiResponseModel.builder()
                    .vin(vin)
                    .make(root.make.name)
                    .model(root.model.name)
                    .year(root.years.get(1).year)
                    .fuel(root.engine.fuelType)
                    .economy(kml)
                    .horsepower(root.engine.horsepower)
                    .displacement(root.engine.displacement)
                    .torque(root.engine.torque)
                    .transmission(transmissionType)
                    .gears(gearsNum)
                    .drivenWheels(drivenWheels)
                    .build();
        }
        catch (Exception e){
            throw new CarNotFoundException();
        }
    }
}
