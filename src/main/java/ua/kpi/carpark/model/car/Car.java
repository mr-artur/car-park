package ua.kpi.carpark.model.car;

public abstract class Car {

    private String model;
    private double fuelConsumption;
    private int price;
    private int maxSpeed;
    private int comfortLevel;

    protected Car(String model, double fuelConsumption, int price,
                  int maxSpeed, int comfortLevel) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.comfortLevel = comfortLevel;
    }

    public String getModel() {
        return model;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}
