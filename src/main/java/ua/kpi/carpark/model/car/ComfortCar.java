package ua.kpi.carpark.model.car;

public class ComfortCar extends Car {

    public ComfortCar(String model, double fuelConsumption, int price,
                      int maxSpeed) {
        super(model, fuelConsumption, price, maxSpeed, 2);
    }
}
