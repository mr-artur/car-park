package ua.kpi.carpark.model.car;

import java.math.BigDecimal;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class PetrolCar extends Car {

    public PetrolCar(BigDecimal consumptionPerKilometer,
                     BigDecimal refuelingTariff, ComfortLevel comfortLevel,
                     String model, int price, int maxSpeed) {
        super(consumptionPerKilometer, refuelingTariff, comfortLevel, model,
              price, maxSpeed);
    }

    @Override
    public BigDecimal calculateFuelCost(int kilometers) {
        BigDecimal consumption = getConsumptionPerKilometer()
                .multiply(BigDecimal.valueOf(kilometers));

        return consumption.multiply(getRefuelingTariff());
    }
}
