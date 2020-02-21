package ua.kpi.carpark.model;

import ua.kpi.carpark.model.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class CarPark {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    /**
     * Returns total price of all cars in car park
     *
     * @return total price
     */
    public int getTotalPrice() {
        return cars.stream()
                .map(Car::getPrice)
                .reduce(0, Integer::sum);
    }

    /**
     * Returns cars filtered by speed range
     *
     * @param bottom minimum speed to match
     * @param top    maximum speed to match
     * @return matching cars
     */
    public List<Car> getBySpeedRange(int bottom, int top) {
        return cars.stream()
                .filter(car -> (car.getMaxSpeed() >= bottom)
                        && (car.getMaxSpeed() <= top))
                .collect(Collectors.toList());
    }

    /**
     * Returns cars sorted by fuel cost in ASC order
     *
     * @return sorted cars
     */
    public List<Car> getSortedByFuelCost() {
        return cars.stream()
                .sorted(Car.COMPARE_BY_FUEL_COST)
                .collect(Collectors.toList());
    }
}
