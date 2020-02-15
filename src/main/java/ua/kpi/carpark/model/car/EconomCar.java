package ua.kpi.carpark.model.car;

public class EconomCar extends Car {

    public EconomCar(String model, double fuelConsumption, int price,
                     int maxSpeed) {
        super(model, fuelConsumption, price, maxSpeed, 1);
    }
}
