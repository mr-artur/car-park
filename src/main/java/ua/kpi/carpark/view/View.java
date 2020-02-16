package ua.kpi.carpark.view;

public class View {

    private Translator translator = new Translator();

    public void setLanguage(String language) {
        translator.setLanguage(language);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String getHeaderField(String key) {
        return translator.getHeaderField(key);
    }

    public void printMenu() {
        for (String key : Constants.menuKeys) {
            printMessage(getMenuMessage(key));
        }
    }

    private String getMenuMessage(String key) {
        return translator.getMenuMessage(key);
    }

    public void printInputMessage() {
        printMessage(translator.getInputMessage(Constants.INPUT_OPERATION_KEY));
    }

    public void printWrongInputMessage() {
        printMessage(translator.getInputMessage(Constants.WRONG_INPUT_KEY));
    }

    public void printInputTopLimitMessage() {
        printMessage(translator.getInputMessage(Constants.TOP_LIMIT_KEY));
    }

    public void printWrongTopLimitMessage(int bottomLimit) {
        printMessage(String.format(translator.getInputMessage(
                Constants.WRONG_TOP_LIMIT_KEY), bottomLimit));
    }

    public void printInputBottomLimitMessage() {
        printMessage(translator.getInputMessage(Constants.BOTTOM_LIMIT_KEY));
    }

    public String getLabel(String key) {
        return translator.getLabel(key);
    }

    public void printTotalPrice(int price) {
        printMessage(String.format(getLabel(Constants.TOTAL_PRICE_KEY), price));
    }

    public int getLength(String field) {
        return translator.getLength(field);
    }
}
