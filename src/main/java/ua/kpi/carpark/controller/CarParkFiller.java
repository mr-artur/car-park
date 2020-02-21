package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.model.car.Car;
import ua.kpi.carpark.model.car.CarFactory;
import ua.kpi.carpark.model.car.ComfortLevel;

import java.math.BigDecimal;
import java.util.List;

public class CarParkFiller {

    private final FileReader reader = new FileReader();
    private final CarFactory factory = CarFactory.getInstance();

    public void fillCarPark(CarPark park) {
        List<String> lines = reader.readFromLine(Constants.DATA_FILE_NAME, 2);
        lines.stream()
                .map(line -> line.split(Constants.DATA_DELIMITER))
                .map(this::createCar)
                .forEach(park::addCar);
    }

    private Car createCar(String[] fields) {
        String type = fields[0];
        BigDecimal consumption = BigDecimal.valueOf(Double.parseDouble(fields[1]));
        BigDecimal tariff = BigDecimal.valueOf(Double.parseDouble(fields[2]));
        String model = fields[3];
        int price = Integer.parseInt(fields[4]);
        int maxSpeed = Integer.parseInt(fields[5]);
        ComfortLevel comfortLevel = ComfortLevel.valueOf(fields[6].toUpperCase());

        return factory.produce(type, consumption, tariff, model, price, maxSpeed, comfortLevel);
    }
}
