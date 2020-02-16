package ua.kpi.carpark.view;

public class Constants {

    public static final String CHOOSE_LANGUAGE_MESSAGE = "Choose language :";
    public static final String CHOOSE_ENGLISH = "- 1. English";
    public static final String CHOOSE_RUSSIAN = "- 2. Русский";

    public static final String RESOURCE_NAME = "messages";
    public static final String INPUT_PREFIX = "input.";
    public static final String MENU_PREFIX = INPUT_PREFIX + "menu.";
    public static final String OUTPUT_PREFIX = "output.";
    public static final String HEADER_PREFIX = OUTPUT_PREFIX + "header.";
    public static final String LENGTH_PREFIX = HEADER_PREFIX + "length.";
    public static final String LABEL_PREFIX = OUTPUT_PREFIX + "label.";

    public static final String INPUT_OPERATION_KEY = "inputOperation";
    public static final String WRONG_INPUT_KEY = "wrongInput";
    public static final String TOP_LIMIT_KEY = "topLimit";
    public static final String WRONG_TOP_LIMIT_KEY = "wrongTopLimit";
    public static final String BOTTOM_LIMIT_KEY = "bottomLimit";
    public static final String TOTAL_PRICE_KEY = "totalPrice";

    public static final String MENU_HEADER_KEY = "menuHeader";
    public static final String SHOW_ALL_KEY = "showAll";
    public static final String SHOW_SORTED_KEY = "showSorted";
    public static final String SHOW_FILTERED_KEY = "showFiltered";
    public static final String SHOW_TOTAL_PRICE_KEY = "showTotalPrice";
    public static final String EXIT_KEY = "exit";

    public static final String[] languageMenu = {
            CHOOSE_LANGUAGE_MESSAGE,
            CHOOSE_ENGLISH,
            CHOOSE_RUSSIAN
    };

    public static final String[] menuKeys = {
            MENU_HEADER_KEY,
            SHOW_ALL_KEY,
            SHOW_SORTED_KEY,
            SHOW_FILTERED_KEY,
            SHOW_TOTAL_PRICE_KEY,
            EXIT_KEY
    };
}
