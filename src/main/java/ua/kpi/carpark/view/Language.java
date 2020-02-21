package ua.kpi.carpark.view;

import java.util.Locale;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public enum Language {
    ENGLISH("To choose English language, enter '0'", "en"),
    RUSSIAN("Чтобы выбрать русский язык, введите '1'", "ru");

    /**
     * min possible ordinal of language
     */
    public static final int MIN_CODE = ENGLISH.ordinal();
    /**
     * max possible ordinal of language
     */
    public static final int MAX_CODE = RUSSIAN.ordinal();

    private final String message;
    private final String shortCode;

    Language(String message, String shortCode) {
        this.message = message;
        this.shortCode = shortCode;
    }

    public String getMessage() {
        return message;
    }

    public Locale getLocale() {
        return new Locale(shortCode);
    }
}
