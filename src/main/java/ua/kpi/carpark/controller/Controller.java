package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.view.Language;
import ua.kpi.carpark.view.View;

import java.util.Scanner;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class Controller {

    private final CarPark carPark;
    private final InputScanner inputScanner;
    private final OutputPrinter printer;
    private final View view;
    private final CarParkFiller filler = new CarParkFiller();
    private final Scanner scanner = new Scanner(System.in);

    public Controller(CarPark carPark, View view) {
        this.carPark = carPark;
        this.view = view;
        inputScanner = new InputScanner(view);
        printer = new OutputPrinter(view);
        filler.fillCarPark(carPark);
    }

    public void start() {
        selectLanguage();
        executeOperations();
    }

    private void selectLanguage() {
        int languageCode = inputScanner.selectLanguage(scanner);
        setLanguage(languageCode);
    }

    private void setLanguage(int languageCode) {
        if (languageCode == Language.ENGLISH.ordinal()) {
            view.setLanguage(Language.ENGLISH);
        } else if (languageCode == Language.RUSSIAN.ordinal()) {
            view.setLanguage(Language.RUSSIAN);
        }
    }

    private void executeOperations() {
        int operation;

        do {
            operation = inputScanner.selectOperation(scanner);
            executeOperation(operation);
        } while (operation != Constants.EXIT_CODE);
    }

    private void executeOperation(int operation) {
        if (operation == Constants.ALL_CODE) {
            showAllCars();
        } else if (operation == Constants.SORTED_CODE) {
            showSortedCars();
        } else if (operation == Constants.FILTERED_CODE) {
            showCarsByRange();
        } else if (operation == Constants.PRICE_CODE) {
            showTotalPrice();
        }
    }

    private void showAllCars() {
        printer.printAllCars(carPark.getCars());
    }

    private void showCarsByRange() {
        int bottom = inputScanner.inputBottomLimit(scanner);
        int top = inputScanner.inputTopLimit(scanner, bottom);
        printer.printCarsByRange(carPark.getBySpeedRange(bottom, top));
    }

    private void showSortedCars() {
        printer.printSortedCars(carPark.getSortedByFuelCost());
    }

    private void showTotalPrice() {
        printer.printTotalPrice(carPark.getTotalPrice());
    }
}
