package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.car.Car;
import ua.kpi.carpark.view.View;
import ua.kpi.carpark.view.ViewConstants;

import java.util.List;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class OutputPrinter {

    private final View view;

    public OutputPrinter(View view) {
        this.view = view;
    }

    /**
     * Prints all cars with appropriate message
     *
     * @param cars cars list
     */
    public void printAllCars(List<Car> cars) {
        view.printTranslatedMessage(ViewConstants.ALL_LABEL);
        view.printCarsTable(cars);
    }

    /**
     * Prints sorted cars with appropriate message
     *
     * @param cars sorted cars list
     */
    public void printSortedCars(List<Car> cars) {
        view.printTranslatedMessage(ViewConstants.SORTED_LABEL);
        view.printCarsTable(cars);
    }

    /**
     * Prints filtered cars by range with appropriate message
     *
     * @param cars filtered cars list
     */
    public void printCarsByRange(List<Car> cars) {
        view.printTranslatedMessage(ViewConstants.FILTERED_LABEL);
        view.printCarsTable(cars);
    }

    /**
     * Prints total price of car park with appropriate message
     *
     * @param price total price
     */
    public void printTotalPrice(Integer price) {
        view.printTranslatedMessage(ViewConstants.TOTAL_PRICE_LABEL);
        view.printMessage(price.toString());
    }
}
