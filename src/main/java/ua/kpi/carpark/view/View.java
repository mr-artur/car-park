package ua.kpi.carpark.view;

import java.util.Locale;

public class View {

    public void changeLanguage(String language) {
        Locale.setDefault(new Locale(language));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
