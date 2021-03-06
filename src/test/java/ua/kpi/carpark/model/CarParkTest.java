package ua.kpi.carpark.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.kpi.carpark.controller.CarParkFiller;
import ua.kpi.carpark.model.car.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarParkTest {

    private static final CarPark carPark = new CarPark();
    private static final CarParkFiller filler = new CarParkFiller();

    @BeforeAll
    static void setUp() {
        filler.fillCarPark(carPark);
    }

    @Test
    void getTotalPrice_shouldReturnTotalPriceOfCarPark() {
        int actual = carPark.getTotalPrice();

        assertEquals(379000, actual);
    }

    @Test
    void getBySpeedRange_shouldReturnEmptyList_whenNoCarHasSpeedInRange() {
        int bottomLimit = 0;
        int topLimit = 1;

        List<Car> cars = carPark.getBySpeedRange(bottomLimit, topLimit);

        assertTrue(cars.isEmpty());
    }

    @Test
    void getBySpeedRange_shouldReturnFilteredCarsList_whenLimitsAreCorrect() {
        int bottomLimit = 0;
        int topLimit = 160;

        List<Car> cars = carPark.getBySpeedRange(bottomLimit, topLimit);
        int firstCarSpeed = cars.get(0).getMaxSpeed();

        assertFalse(cars.isEmpty());
        assertTrue(isInRange(firstCarSpeed, bottomLimit, topLimit));
    }

    private boolean isInRange(int speed, int bottomLimit, int topLimit) {
        return (speed <= topLimit) && (speed >= bottomLimit);
    }

    @Test
    void getSortedByFuelCost_shouldReturnCarsListSortedByFuelCost() {
        int distance = 1;

        List<Car> cars = carPark.getSortedByFuelCost();
        double firstCarFuelCost = cars.get(0)
                .calculateFuelCost(distance)
                .doubleValue();
        double secondCarFuelCost = cars.get(1)
                .calculateFuelCost(distance)
                .doubleValue();
        double lastCarConsumption = cars.get(cars.size() - 1)
                .calculateFuelCost(distance)
                .doubleValue();

        assertTrue(firstCarFuelCost <= secondCarFuelCost);
        assertTrue(secondCarFuelCost <= lastCarConsumption);
    }
}
