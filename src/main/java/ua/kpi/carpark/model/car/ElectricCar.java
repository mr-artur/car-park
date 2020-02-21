package ua.kpi.carpark.model.car;

import java.math.BigDecimal;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class ElectricCar extends Car {

    public static final BigDecimal LOSS_RATIO = BigDecimal.valueOf(1.4);

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

        return costWithoutLosses.multiply(LOSS_RATIO);
    }
}
