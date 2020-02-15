package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.view.View;

import java.util.Scanner;

public class Controller {

    private final CarPark carPark;
    private final InputScanner inputScanner;
    private final OutputPrinter printer;
    private final CarParkFiller filler;
    private final Scanner scanner = new Scanner(System.in);

    public Controller(CarPark carPark, View view) {
        this.carPark = carPark;
        this.inputScanner = new InputScanner(view);
        this.printer = new OutputPrinter(view);
        this.filler = new CarParkFiller();
        filler.fillCarPark(carPark);
    }

    public void start() {
        int operation;

        do {
            operation = inputScanner.selectOperation(scanner);
            executeOperation(operation);
        } while (operation != 0);
    }

    private void executeOperation(int operation) {
        if (operation == 1) {
            printer.printCars(carPark.getCars());
        } else if (operation == 2) {
            int bottom = inputScanner.inputBottomLimit(scanner);
            int top = inputScanner.inputTopLimit(scanner, bottom);
            printer.printCars(carPark.getBySpeedRange(bottom, top));
        } else if (operation == 3) {
            printer.printCars(carPark.getSortedByConsumption());
        } else if (operation == 4) {
            printer.printTotalPrice(carPark.getTotalPrice());
        }
    }
}
