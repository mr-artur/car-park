package ua.kpi.carpark.view;

import ua.kpi.carpark.model.car.Car;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class View {

    private ResourceBundle bundle;
    private Formatter formatter;

    public View(Formatter formatter) {
        this.formatter = formatter;
        setLanguage(Language.ENGLISH);
        formatter.setBundle(bundle);
    }

    public void setLanguage(Language language) {
        bundle = ResourceBundle.getBundle(ViewConstants.BUNDLE_NAME,
                                          language.getLocale());
        formatter.setBundle(bundle);
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
        printMessage(formatter.formatHeader());
        printMessage(formatter.formatBody(cars));
    }
}
