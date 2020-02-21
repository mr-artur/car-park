package ua.kpi.carpark.view;

import ua.kpi.carpark.model.car.Car;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class Formatter {

    public static final String DELIMITER = "|";
    public static final char HORIZONTAL_DELIMITER = '-';
    public static final String LINE_BREAK = "\n";
    public static final String EMPTY = "";

    public String formatHeader(Map<String, Integer> headers) {
        StringJoiner joiner = new StringJoiner(DELIMITER, DELIMITER, DELIMITER);

        for (Map.Entry<String, Integer> header : headers.entrySet()) {
            int length = header.getValue();
            String headerText = header.getKey();
            String formatted = String.format("%-" + length + "s", headerText);
            joiner.add(formatted);
        }
        String lineDelimiter = buildStringOfCharCopies(joiner.length(), HORIZONTAL_DELIMITER);
        return new StringJoiner(LINE_BREAK)
                .add(lineDelimiter)
                .add(joiner.toString())
                .add(lineDelimiter)
                .toString();
    }

    public String formatBody(List<Car> cars, List<Integer> lengths) {
        String lineDelimiter = buildLineDelimiter(lengths);

        StringJoiner joiner = new StringJoiner(LINE_BREAK);

        for (int i = 0; i < cars.size(); i++) {
            joiner.add(formatLine(i + 1, cars.get(i), lengths));
            joiner.add(lineDelimiter);
        }
        return joiner.toString();
    }

    private String formatLine(Integer number, Car car, List<Integer> lengths) {
        StringJoiner joiner = new StringJoiner(DELIMITER, DELIMITER, DELIMITER);
        BigDecimal fuelCost = car.calculateFuelCost(100).setScale(2, RoundingMode.HALF_UP);
        BigDecimal tariff = car.calculateFare(1).setScale(1);

        joiner.add(formatCell(lengths.get(0), number.toString()));
        joiner.add(formatCell(lengths.get(1), car.getModel()));
        joiner.add(formatCell(lengths.get(2), car.getPrice().toString()));
        joiner.add(formatCell(lengths.get(3), car.getMaxSpeed().toString()));
        joiner.add(formatCell(lengths.get(4), car.getComfortLevel().toString()));
        joiner.add(formatCell(lengths.get(5), fuelCost.toString()));
        joiner.add(formatCell(lengths.get(6), tariff.toString()));
        return joiner.toString();
    }

    private String formatCell(Integer length, String data) {
        String formatWithLength = buildFormatWithLength(length);
        return String.format(formatWithLength, data);
    }

    private String buildFormatWithLength(int length) {
        return String.format("%%-%ds", length);
    }

    private String buildLineDelimiter(List<Integer> lengths) {
        int length = lengths.stream().reduce(0, (acc, len) -> acc + len);
        int lengthWithBorders = length + lengths.size() + 1;
        return buildStringOfCharCopies(lengthWithBorders, HORIZONTAL_DELIMITER);
    }

    private String buildStringOfCharCopies(int repeats, char symbol) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < repeats; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }
}
