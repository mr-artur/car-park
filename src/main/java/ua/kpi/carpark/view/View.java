package ua.kpi.carpark.view;

import ua.kpi.carpark.model.car.Car;

import java.util.*;

public class View {

    public static final String TOP_LIMIT = "input.top.limit";
    public static final String WRONG_TOP_LIMIT = "wrong.top.limit";
    public static final String BOTTOM_LIMIT = "input.bottom.limit";
    public static final String WRONG_INPUT = "input.wrong";
    public static final String INPUT_OPERATION= "input.operation";
    public static final String TOTAL_PRICE_LABEL = "output.label.total.price";
    public static final String SORTED_LABEL = "output.label.sorted";
    public static final String FILTERED_LABEL = "output.label.filtered";
    public static final String ALL_LABEL = "output.label.all";
    public static final String BUNDLE_NAME = "messages";
    public static final String MENU = "input.menu";

    private ResourceBundle bundle;
    private Formatter formatter;

    public View(Formatter formatter) {
        this.formatter = formatter;
        setLanguage(Language.ENGLISH);
    }

    public void setLanguage(Language language) {
        bundle = ResourceBundle.getBundle(BUNDLE_NAME, language.getLocale());
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

    public void printMenu() {
        printMessage(bundle.getString(MENU));
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
