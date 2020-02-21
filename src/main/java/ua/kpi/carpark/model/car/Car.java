package ua.kpi.carpark.model.car;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public abstract class Car {

    /**
     * Comparator can be used to compare/sort cars by fuel cost in ASC order
     */
    public static final Comparator<Car> COMPARE_BY_FUEL_COST = (car1, car2) -> {
        final int distance = 1;

        BigDecimal fuelCost1 = car1.calculateFuelCost(distance);
        BigDecimal fuelCost2 = car2.calculateFuelCost(distance);

        return fuelCost1.compareTo(fuelCost2);
    };

    /**
     * Basic fare per 1 km
     */
    public static final BigDecimal TARIFF_PER_KILOMETER = BigDecimal.valueOf(1);

    protected BigDecimal consumptionPerKilometer;
    protected BigDecimal refuelingTariff;
    private String model;
    private Integer price;
    private Integer maxSpeed;
    private ComfortLevel comfortLevel;

    protected Car(BigDecimal consumptionPerKilometer,
                  BigDecimal refuelingTariff, ComfortLevel comfortLevel,
                  String model, int price, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.comfortLevel = comfortLevel;
        this.refuelingTariff = refuelingTariff;
        this.consumptionPerKilometer = consumptionPerKilometer;
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

    /**
     * Returns tariff cost per n kilometers
     *
     * @param kilometers travel distance
     * @return tariff cost
     */
    public BigDecimal calculateFare(int kilometers) {
        BigDecimal basicTariff = TARIFF_PER_KILOMETER
                .multiply(BigDecimal.valueOf(kilometers));

        return basicTariff.multiply(comfortLevel.getCoefficient());
    }

    /**
     * Returns cost of fuel consumed per n kilometers
     *
     * @param kilometers travel distance
     * @return cost of fuel
     */
    public abstract BigDecimal calculateFuelCost(int kilometers);
}
