package ua.kpi.carpark.model.car;

public final class CarFactory {

    private static class CarFactoryHolder {
        private static final CarFactory instance = new CarFactory();
    }

    public static CarFactory getInstance() {
        return CarFactoryHolder.instance;
    }

    private CarFactory() {
    }

    public Car produce(String type, String model, double fuelConsumption,
                       int price, int maxSpeed) {
        Car car;

        switch (type) {
            case "ECONOM":
                car = new EconomCar(model, fuelConsumption, price, maxSpeed);
                break;
            case "COMFORT":
                car = new ComfortCar(model, fuelConsumption, price, maxSpeed);
                break;
            case "BUSINESS":
                car = new BusinessCar(model, fuelConsumption, price, maxSpeed);
                break;
            default:
                throw new IllegalArgumentException("Wrong car type" + type);
        }
        return car;
    }
}
