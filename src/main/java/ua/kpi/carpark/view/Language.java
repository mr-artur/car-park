package ua.kpi.carpark.view;

import java.util.Locale;

public enum Language {
    ENGLISH("To choose English language, enter '1'", "en", 1),
    RUSSIAN("Чтобы выбрать русский язык, введите '2'", "ru", 2);

    private final String message;
    private final String shortCode;
    private final int code;

    Language(String message, String shortCode, int code) {
        this.message = message;
        this.shortCode = shortCode;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Locale getLocale() {
        return new Locale(shortCode);
    }
}
