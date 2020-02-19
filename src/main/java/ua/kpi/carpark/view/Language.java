package ua.kpi.carpark.view;

import java.util.Locale;

public enum Language {
    ENGLISH("To choose English language, enter '1'", "en"),
    RUSSIAN("Чтобы выбрать русский язык, введите '2'", "ru");

    private final String message;
    private final String shortCode;

    Language(String message, String shortCode){
        this.message = message;
        this.shortCode = shortCode;
    }

    public String getMessage() {
        return message;
    }

    public String getShortCode() {
        return shortCode;
    }

    public Locale getLocale(){
        return new Locale(shortCode);
    }
}
