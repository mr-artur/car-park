package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.model.car.Car;
import ua.kpi.carpark.model.car.CarFactory;

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
        String model = fields[1];
        double fuelConsumption = Double.parseDouble(fields[2]);
        int price = Integer.parseInt(fields[3]);
        int maxSpeed = Integer.parseInt(fields[4]);

        return factory.produce(type, model, fuelConsumption, price, maxSpeed);
    }
}
