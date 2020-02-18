package ua.kpi.carpark.model;

import ua.kpi.carpark.model.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarPark {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalPrice() {
        return cars.stream()
                .map(car -> car.getPrice())
                .reduce(0, (acc, price) -> acc + price);
    }

    public List<Car> getBySpeedRange(int bottom, int top) {
        Predicate<Car> criteria = car -> (car.getMaxSpeed() >= bottom)
                && (car.getMaxSpeed() <= top);
        return cars.stream()
                .filter(criteria)
                .collect(Collectors.toList());
    }

    public List<Car> getSortedByFuelCost() {
        return cars.stream()
                .sorted(Car.COMPARE_BY_FUEL_COST)
                .collect(Collectors.toList());
    }
}
