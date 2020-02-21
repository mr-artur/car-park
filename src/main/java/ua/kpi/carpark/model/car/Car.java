package ua.kpi.carpark.model.car;

import java.math.BigDecimal;
import java.util.Comparator;

public abstract class Car {

    public static final Comparator<Car> COMPARE_BY_FUEL_COST = (car1, car2) -> {
        final int distance = 1;

        BigDecimal fuelCost1 = car1.calculateFuelCost(distance);
        BigDecimal fuelCost2 = car2.calculateFuelCost(distance);

        return fuelCost1.compareTo(fuelCost2);
    };
    public static final BigDecimal TARIFF_PER_KILOMETER = BigDecimal.valueOf(1);
    protected BigDecimal consumptionPerKilometer;
    protected BigDecimal refuelingTariff;
    private String model;
    private Integer price;
    private Integer maxSpeed;
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

    public Integer getPrice() {
        return price;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public BigDecimal calculateTariffCost(int kilometers) {
        BigDecimal basicTariff = TARIFF_PER_KILOMETER.multiply(
                BigDecimal.valueOf(kilometers));

        return basicTariff.multiply(comfortLevel.getCoefficient());
    }

    public abstract BigDecimal calculateFuelCost(int kilometers);
}
