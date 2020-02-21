package ua.kpi.carpark.model.car.factory;

import ua.kpi.carpark.model.car.Car;
import ua.kpi.carpark.model.car.ComfortLevel;
import ua.kpi.carpark.model.car.ElectricCar;
import ua.kpi.carpark.model.car.PetrolCar;

import java.math.BigDecimal;

/**
 * Created by Artur Morozov on 2020-02-16
 */
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
        TypeCar sign = TypeCar.valueOf(type.toUpperCase());
        Car car;

        switch (sign) {
            case ELECTRIC:
                car = new ElectricCar(consumptionPerKilometer, refuelingTariff,
                        model, price, maxSpeed, comfortLevel);
                break;
            case PETROL:
                car = new PetrolCar(consumptionPerKilometer, refuelingTariff,
                        model, price, maxSpeed, comfortLevel);
                break;
            default:
                throw new IllegalArgumentException("Wrong car type : " + type);
        }
        return car;
    }
}
