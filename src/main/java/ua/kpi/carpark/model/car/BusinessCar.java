package ua.kpi.carpark.model.car;

public class BusinessCar extends Car {

    public BusinessCar(String model, double fuelConsumption, int price,
                       int maxSpeed) {
        super(model, fuelConsumption, price, maxSpeed, 3);
    }
}
