package ua.kpi.carpark.model;

import ua.kpi.carpark.model.car.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarPark {

    private List<Car> cars = new ArrayList<>();

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

    public List<Car> findBySpeed(int bottom, int top) {
        Predicate<Car> criteria = car -> (car.getMaxSpeed() >= bottom)
                && (car.getMaxSpeed() <= top);
        return cars.stream()
                .filter(criteria)
                .collect(Collectors.toList());
    }

    public List<Car> getSortedByConsumption() {
        return cars.stream()
                .sorted(Comparator.comparingDouble(Car::getFuelConsumption))
                .collect(Collectors.toList());
    }
}
