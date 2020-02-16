package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.car.Car;
import ua.kpi.carpark.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class OutputPrinter {

    private String format;
    private String lineDelimiter;
    private View view;

    public OutputPrinter(View view) {
        this.view = view;
    }

    private int calculateLineLength() {
        List<Integer> lengths = new ArrayList<>();
        int lineLength = 0;
        lengths.add(view.getLength("number"));
        lengths.add(view.getLength("model"));
        lengths.add(view.getLength("consumption"));
        lengths.add(view.getLength("price"));
        lengths.add(view.getLength("maxSpeed"));
        lengths.add(view.getLength("comfortLevel"));
        for (int length : lengths) {
            lineLength += length;
        }
        lineLength += lengths.size() + 1;
        return lineLength;
    }

    private void buildFormat() {
        format = new StringJoiner("|", "|", "|")
                .add(formatWithLength("number"))
                .add(formatWithLength("model"))
                .add(formatWithLength("consumption"))
                .add(formatWithLength("price"))
                .add(formatWithLength("maxSpeed"))
                .add(formatWithLength("comfortLevel"))
                .toString();
    }

    private void buildLineDelimiter() {
        int length = calculateLineLength();
        lineDelimiter = buildStringOfCharCopies(length, '-');
    }

    private String formatWithLength(String field) {
        return String.format("%%-%ds", view.getLength(field));
    }

    private static String buildStringOfCharCopies(int repeats, char symbol) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < repeats; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }

    public void printTotalPrice(int price) {
        view.printTotalPrice(price);
    }

    public void printCars(List<Car> cars) {
        updateFormat();
        printHeader();
        printBody(cars);
    }

    private void updateFormat() {
        buildFormat();
        buildLineDelimiter();
    }

    private void printHeader() {
        String header = String.format(format,
                view.getHeaderMessage("number"),
                view.getHeaderMessage("model"),
                view.getHeaderMessage("consumption"),
                view.getHeaderMessage("price"),
                view.getHeaderMessage("maxSpeed"),
                view.getHeaderMessage("comfortLevel"));
        view.printMessage(lineDelimiter);
        view.printMessage(header);
        view.printMessage(lineDelimiter);
    }

    private void printBody(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            printLine(i + 1, cars.get(i));
        }
    }

    private void printLine(int number, Car car) {
        view.printMessage(String.format(format,
                Integer.valueOf(number).toString(), car.getModel(),
                car.getFuelConsumption(), car.getPrice(), car.getMaxSpeed(),
                car.getComfortLevel()));
        view.printMessage(lineDelimiter);
    }
}
