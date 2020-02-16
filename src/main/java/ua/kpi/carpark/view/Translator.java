package ua.kpi.carpark.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {

    public static final String DEFAULT_LANGUAGE = "en";
    public static final String RESOURCE_NAME = "messages";
    public static final String INPUT_PREFIX = "input.";
    public static final String MENU_PREFIX = INPUT_PREFIX + "menu.";
    public static final String OUTPUT_PREFIX = "output.";
    public static final String HEADER_PREFIX = OUTPUT_PREFIX + "header.";
    public static final String LENGTH_PREFIX = HEADER_PREFIX + "length.";
    public static final String LABEL_PREFIX = OUTPUT_PREFIX + "label.";
    private ResourceBundle bundle;

    public Translator() {
        setLanguage(DEFAULT_LANGUAGE);
    }

    public void setLanguage(String language) {
        bundle = ResourceBundle.getBundle(RESOURCE_NAME, new Locale(language));
    }

    public int getLength(String key) {
        return Integer.parseInt(bundle.getString(LENGTH_PREFIX + key));
    }

    public String getMenuMessage(String key) {
        return bundle.getString(MENU_PREFIX + key);
    }

    public String getHeaderMessage(String key) {
        return bundle.getString(HEADER_PREFIX + key);
    }

    public String getInputMessage(String key) {
        return bundle.getString(INPUT_PREFIX + key);
    }

    public String getLabel(String key) {
        return bundle.getString(LABEL_PREFIX + key);
    }
}
