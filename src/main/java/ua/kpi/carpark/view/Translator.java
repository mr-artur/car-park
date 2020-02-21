package ua.kpi.carpark.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {

    private ResourceBundle bundle;

    public Translator() {
     //  setLanguage(Constants.RESOURCE_NAME);
    }

    public void setLanguage(String language) {

    }

    public int getLength(String key) {
        return Integer.parseInt(
                bundle.getString(Constants.LENGTH_PREFIX + key));
    }

    public String getMenuMessage(String key) {
        return bundle.getString(Constants.MENU_PREFIX + key);
    }

    public String getHeaderField(String key) {
        return bundle.getString(Constants.HEADER_PREFIX + key);
    }

    public String getInputMessage(String key) {
        return bundle.getString(Constants.INPUT_PREFIX + key);
    }

    public String getLabel(String key) {
        return bundle.getString(Constants.LABEL_PREFIX + key);
    }
}
