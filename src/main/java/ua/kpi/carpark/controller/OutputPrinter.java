package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.car.Car;
import ua.kpi.carpark.view.View;

import java.util.List;
import java.util.StringJoiner;

public class OutputPrinter {

    public static final int NUMBER_LENGTH = 2;
    public static final int MODEL_LENGTH = 16;
    public static final int FUEL_CONSUMPTION_LENGTH = 6;
    public static final int PRICE_LENGTH = 7;
    public static final int MAX_SPEED_LENGTH = 9;
    public static final int COMFORT_LEVEL_LENGTH = 13;
    public static final int DELIMITER_LENGTH = 1;
    public static final int LINE_LENGTH = DELIMITER_LENGTH + NUMBER_LENGTH
            + DELIMITER_LENGTH + MODEL_LENGTH + DELIMITER_LENGTH
            + FUEL_CONSUMPTION_LENGTH + DELIMITER_LENGTH + PRICE_LENGTH
            + DELIMITER_LENGTH + MAX_SPEED_LENGTH + DELIMITER_LENGTH
            + COMFORT_LEVEL_LENGTH + DELIMITER_LENGTH;
    public static final String FORMAT;
    public static final String LINE_DELIMITER;
    private View view;

    static {
        FORMAT = new StringJoiner("|", "|", "|")
                .add(String.format("%%-%ds", NUMBER_LENGTH))
                .add(String.format("%%-%ds", MODEL_LENGTH))
                .add(String.format("%%-%ds", FUEL_CONSUMPTION_LENGTH))
                .add(String.format("%%-%ds", PRICE_LENGTH))
                .add(String.format("%%-%ds", MAX_SPEED_LENGTH))
                .add(String.format("%%-%ds", COMFORT_LEVEL_LENGTH))
                .toString();
        LINE_DELIMITER = buildStringOfCharCopies(LINE_LENGTH, '-');
    }

    public OutputPrinter(View view) {
        this.view = view;
    }

    private static String buildStringOfCharCopies(int repeats, char symbol) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < repeats; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }

    public void printCarsTable(List<Car> cars) {
        printHeader();
        printBody(cars);
    }

    private void printHeader() {
        String header = String.format(FORMAT, "№", "Model", "FC l/h", "Price",
                "Max Speed", "Comfort Level");
        view.printMessage(LINE_DELIMITER);
        view.printMessage(header);
        view.printMessage(LINE_DELIMITER);
    }

    private void printBody(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            printLine(i + 1, cars.get(i));
        }
    }

    private void printLine(int number, Car car) {
        view.printMessage(String.format(FORMAT,
                Integer.valueOf(number).toString(), car.getModel(),
                car.getFuelConsumption(), car.getPrice(), car.getMaxSpeed(),
                car.getComfortLevel()));
        view.printMessage(LINE_DELIMITER);
    }
}
