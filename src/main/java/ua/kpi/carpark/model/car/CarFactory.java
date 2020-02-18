package ua.kpi.carpark.model.car;

import java.math.BigDecimal;

public final class CarFactory {

    private static class CarFactoryHolder {
        private static final CarFactory instance = new CarFactory();
    }

    public static CarFactory getInstance() {
        return CarFactoryHolder.instance;
    }

    private CarFactory() {
    }

    public Car produce(String type, BigDecimal consumptionPerKilometer,
                       BigDecimal refuelingTariff, String model, int price,
                       int maxSpeed, ComfortLevel comfortLevel) {
        Car car;

        switch (type) {
            case "ELECTRIC":
                car = new ElectricCar(consumptionPerKilometer, refuelingTariff,
                        model, price, maxSpeed, comfortLevel);
                break;
            case "PETROL":
                car = new PetrolCar(consumptionPerKilometer, refuelingTariff,
                        model, price, maxSpeed, comfortLevel);
                break;
            default:
                throw new IllegalArgumentException("Wrong car type : " + type);
        }
        return car;
    }
}
