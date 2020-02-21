package ua.kpi.carpark.view;

import ua.kpi.carpark.model.car.Car;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class View {

    private ResourceBundle bundle;
    private Formatter formatter;

    public View(Formatter formatter) {
        this.formatter = formatter;
        setLanguage(Language.ENGLISH);
    }

    public void setLanguage(Language language) {
        bundle = ResourceBundle.getBundle(ViewConstants.BUNDLE_NAME,
                language.getLocale());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printTranslatedMessage(String key) {
        printMessage(bundle.getString(key));
    }

    public void printLanguageMenu() {
        for (Language language : Language.values()) {
            printMessage(language.getMessage());
        }
    }

    public void printCarsTable(List<Car> cars) {
        printHeader();
        printBody(cars);
    }

    private void printHeader() {
        Map<String, Integer> columnHeaders = getTranslatedHeaders();
        printMessage(formatter.formatHeader(columnHeaders));
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

    private void printBody(List<Car> cars) {
        List<Integer> lengths = getHeaderLengths();
        printMessage(formatter.formatBody(cars, lengths));
    }

    private List<Integer> getHeaderLengths() {
        List<Integer> lengths = new ArrayList<>();

        for (CarTableColumn column : CarTableColumn.values()) {
            int length = Integer.parseInt(bundle.getString(column.getLength()));
            lengths.add(length);
        }
        return lengths;
    }
}
