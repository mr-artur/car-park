package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.view.View;

import java.util.Scanner;

public class Controller {

    private final CarPark carPark;
    private final InputScanner inputScanner;
    private final OutputPrinter printer;
    private final CarParkFiller filler = new CarParkFiller();
    private final Scanner scanner = new Scanner(System.in);

    public Controller(CarPark carPark, View view) {
        this.carPark = carPark;
        inputScanner = new InputScanner(view);
        printer = new OutputPrinter(view);
        filler.fillCarPark(carPark);
    }

    public void start() {
        int operation;

        do {
            operation = inputScanner.selectOperation(scanner);
            executeOperation(operation);
        } while (operation != Constants.EXIT_CODE);
    }

    private void executeOperation(int operation) {
        if (operation == Constants.FIRST_OPERATION_CODE) {
            printAllCars();
        } else if (operation == Constants.SECOND_OPERATION_CODE) {
            printSortedCars();
        } else if (operation == Constants.THIRD_OPERATION_CODE) {
            printCarsByRange();
        } else if (operation == Constants.FOURTH_OPERATION_CODE) {
            printTotalPrice();
        }
    }

    private void printAllCars() {
        printer.printAllCars(carPark.getCars());
    }

    private void printCarsByRange() {
        int bottom = inputScanner.inputBottomLimit(scanner);
        int top = inputScanner.inputTopLimit(scanner, bottom);
        printer.printCarsByRange(carPark.getBySpeedRange(bottom, top));
    }

    private void printSortedCars() {
        printer.printSortedCars(carPark.getSortedByConsumption());
    }

    private void printTotalPrice() {
        printer.printTotalPrice(carPark.getTotalPrice());
    }
}
