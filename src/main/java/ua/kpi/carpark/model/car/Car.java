package ua.kpi.carpark.model.car;

import java.math.BigDecimal;
import java.util.Comparator;

public abstract class Car {

    public static final Comparator<Car> COMPARE_BY_FUEL_COST = (car1, car2) -> {
        BigDecimal fuelCost1 = car1.calculateFuelCost(1);
        BigDecimal fuelCost2 = car2.calculateFuelCost(1);
        return fuelCost1.compareTo(fuelCost2);
    };
    public static final BigDecimal TARIFF_PER_KILOMETER = BigDecimal.ONE;
    protected BigDecimal consumptionPerKilometer;
    protected BigDecimal refuelingTariff;
    private String model;
    private int price;
    private int maxSpeed;
    private ComfortLevel comfortLevel;

    protected Car(BigDecimal consumptionPerKilometer,
                  BigDecimal refuelingTariff, String model, int price,
                  int maxSpeed, ComfortLevel comfortLevel) {
        this.consumptionPerKilometer = consumptionPerKilometer;
        this.refuelingTariff = refuelingTariff;
        this.model = model;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.comfortLevel = comfortLevel;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public BigDecimal calculateTariffCost(int kilometers) {
        BigDecimal basicTariff = TARIFF_PER_KILOMETER.multiply(
                BigDecimal.valueOf(kilometers));

        return basicTariff.multiply(
                BigDecimal.valueOf(comfortLevel.getCoefficient()));
    }

    public abstract BigDecimal calculateFuelCost(int kilometers);
}
