package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.car.Car;
import ua.kpi.carpark.view.View;

import java.util.List;

public class OutputPrinter {
    //
//    private String format;
//    private String lineDelimiter;
    private final View view;

    public OutputPrinter(View view) {
        this.view = view;
    }


    public void printAllCars(List<Car> cars) {
        view.printTranslatedMessage(View.ALL_LABEL);
        view.printCarsTable(cars);
    }

    public void printSortedCars(List<Car> cars) {
        view.printTranslatedMessage(View.SORTED_LABEL);
        view.printCarsTable(cars);
    }

    public void printCarsByRange(List<Car> cars) {
        view.printTranslatedMessage(View.FILTERED_LABEL);
        view.printCarsTable(cars);
    }

    public void printTotalPrice(Integer price) {
        view.printTranslatedMessage(View.TOTAL_PRICE_LABEL);
        view.printMessage(price.toString());
    }
//
//    private void printCars(List<Car> cars) {
//        updateFormat();
//        printHeader();
//        printBody(cars);
//    }
//
//    private void updateFormat() {
//        buildFormat();
//        buildLineDelimiter();
//    }
//
//    private void buildFormat() {
//        StringJoiner joiner = new StringJoiner(Constants.VERTICAL_BORDER,
//                Constants.VERTICAL_BORDER, Constants.VERTICAL_BORDER);
//
//        for (String field : Constants.fields) {
//            joiner.add(formatWithLength(field));
//        }
//        format = joiner.toString();
//    }
//
//    private String formatWithLength(String field) {
//        return String.format(Constants.CUSTOM_LENGTH_FORMAT,
//                view.getLength(field));
//    }
//
//    private void buildLineDelimiter() {
//        int length = calculateLineLength();
//
//        lineDelimiter = buildStringOfCharCopies(length,
//                Constants.HORIZONTAL_BORDER);
//    }
//
//    private int calculateLineLength() {
//        int lineLength = 0;
//
//        for (String field : Constants.fields) {
//            lineLength += view.getLength(field);
//        }
//        lineLength += Constants.fields.length + 1;
//        return lineLength;
//    }
//
//
//
//    private void printHeader() {
//        String header = buildHeader();
//        printHeaderWithDelimiters(header);
//    }
//
//    private String buildHeader() {
//        List<String> fields = List.of(Constants.fields)
//                .stream()
//                .map(field -> view.getHeaderField(field))
//                .collect(Collectors.toList());
//        return String.format(format, fields.get(0), fields.get(1),
//                fields.get(2), fields.get(3), fields.get(4), fields.get(5));
//    }
//
//    private void printHeaderWithDelimiters(String header) {
//        view.printMessage(lineDelimiter, header, lineDelimiter);
//    }
//
//    private void printBody(List<Car> cars) {
//        for (int i = 0; i < cars.size(); i++) {
//            printLine(i + 1, cars.get(i));
//        }
//    }

//    private void printLine(int number, Car car) {
//        view.printMessage(String.format(format,
//                Integer.valueOf(number).toString(), car.getModel(),
//                car.getFuelConsumption(), car.getPrice(), car.getMaxSpeed(),
//                car.getComfortLevel()), lineDelimiter);
//    }
}
