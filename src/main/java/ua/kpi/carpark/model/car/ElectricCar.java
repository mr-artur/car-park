package ua.kpi.carpark.model.car;

import java.math.BigDecimal;

public class ElectricCar extends Car {

    public static final double LOSS_RATIO = 1.4;

    public ElectricCar(BigDecimal consumptionPerKilometer,
                       BigDecimal refuelingTariff, String model, int price,
                       int maxSpeed, ComfortLevel comfortLevel) {
        super(consumptionPerKilometer, refuelingTariff, model, price, maxSpeed,
                comfortLevel);
    }

    @Override
    public BigDecimal calculateFuelCost(int kilometers) {
        BigDecimal consumption = consumptionPerKilometer.multiply(
                BigDecimal.valueOf(kilometers));

        BigDecimal costWithoutLosses = consumption.multiply(refuelingTariff);

        return costWithoutLosses.multiply(BigDecimal.valueOf(LOSS_RATIO));
    }
}
