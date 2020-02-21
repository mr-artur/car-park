package ua.kpi.carpark.view;

import ua.kpi.carpark.model.car.Car;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringJoiner;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class Formatter {

    private ResourceBundle bundle;

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    /**
     * Returns formatted header of cars table with local language
     *
     * @return formatted header
     */
    public String formatHeader() {
        Map<String, Integer> headers = getTranslatedHeaders();
        StringJoiner joiner = new StringJoiner(ViewConstants.VERTICAL_DELIMITER,
                                               ViewConstants.VERTICAL_DELIMITER,
                                               ViewConstants.VERTICAL_DELIMITER);

        buildHeaderRow(headers, joiner);
        String delimiter = buildStringOfCharCopies(joiner.length(),
                                                   ViewConstants.HORIZONTAL_DELIMITER);

        return wrapHeader(joiner, delimiter);
    }

    private Map<String, Integer> getTranslatedHeaders() {
        Map<String, Integer> headers = new LinkedHashMap<>();

        for (CarTableColumn column : CarTableColumn.values()) {
            String columnHeader = bundle.getString(column.getKey());
            int length = Integer.parseInt(bundle.getString(column.getLength()));
            headers.put(columnHeader, length);
        }
        return headers;
    }

    private void buildHeaderRow(Map<String, Integer> headers,
                                StringJoiner joiner) {
        for (Map.Entry<String, Integer> header : headers.entrySet()) {
            int length = header.getValue();
            String headerText = header.getKey();
            String formatted = formatColumnHeader(length, headerText);
            joiner.add(formatted);
        }
    }

    private String formatColumnHeader(int length, String headerText) {
        String format = buildFormatWithLength(length);
        return String.format(format, headerText);
    }

    private String wrapHeader(StringJoiner joiner, String lineDelimiter) {
        return new StringJoiner(ViewConstants.LINE_BREAK)
                .add(lineDelimiter)
                .add(joiner.toString())
                .add(lineDelimiter)
                .toString();
    }

    /**
     * Returns formatted body of cars table
     *
     * @param cars cars list to format
     * @return formatted car lines
     */
    public String formatBody(List<Car> cars) {
        List<Integer> lengths = getColumnLengths();
        String lineDelimiter = buildLineDelimiter(lengths);

        return formatBody(cars, lengths, lineDelimiter);
    }

    private List<Integer> getColumnLengths() {
        List<Integer> lengths = new ArrayList<>();

        for (CarTableColumn column : CarTableColumn.values()) {
            int length = Integer.parseInt(bundle.getString(column.getLength()));
            lengths.add(length);
        }
        return lengths;
    }

    private String formatBody(List<Car> cars, List<Integer> lengths,
                              String lineDelimiter) {
        StringJoiner joiner = new StringJoiner(ViewConstants.LINE_BREAK);

        for (int i = 0; i < cars.size(); i++) {
            joiner.add(formatLine(i + 1, cars.get(i), lengths));
            joiner.add(lineDelimiter);
        }
        return joiner.toString();
    }

    private String formatLine(Integer number, Car car, List<Integer> lengths) {
        StringJoiner joiner = new StringJoiner(ViewConstants.VERTICAL_DELIMITER,
                                               ViewConstants.VERTICAL_DELIMITER,
                                               ViewConstants.VERTICAL_DELIMITER);

        BigDecimal fuelCost = getFormattedFuelCost(car);
        BigDecimal tariff = getFormattedTariff(car);

        joiner.add(formatCell(lengths.get(0), number.toString()));
        joiner.add(formatCell(lengths.get(1), car.getModel()));
        joiner.add(formatCell(lengths.get(2), car.getPrice().toString()));
        joiner.add(formatCell(lengths.get(3), car.getMaxSpeed().toString()));
        joiner.add(formatCell(lengths.get(4),
                              car.getComfortLevel().toString()));
        joiner.add(formatCell(lengths.get(5), fuelCost.toString()));
        joiner.add(formatCell(lengths.get(6), tariff.toString()));
        return joiner.toString();
    }

    private BigDecimal getFormattedFuelCost(Car car) {
        return car.calculateFuelCost(ViewConstants.DISTANCE)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getFormattedTariff(Car car) {
        return car.calculateFare(1)
                .setScale(1, RoundingMode.HALF_UP);
    }

    private String formatCell(Integer length, String data) {
        String formatWithLength = buildFormatWithLength(length);
        return String.format(formatWithLength, data);
    }

    private String buildFormatWithLength(int length) {
        return String.format(ViewConstants.FIXED_LENGTH_FORMAT, length);
    }

    private String buildLineDelimiter(List<Integer> lengths) {
        int length = lengths.stream().reduce(0, Integer::sum);
        int lengthWithBorders = length + lengths.size() + 1;
        return buildStringOfCharCopies(lengthWithBorders,
                                       ViewConstants.HORIZONTAL_DELIMITER);
    }

    private String buildStringOfCharCopies(int repeats, char symbol) {
        return String.valueOf(symbol).repeat(Math.max(0, repeats));
    }
}
