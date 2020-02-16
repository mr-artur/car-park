package ua.kpi.carpark.view;

import java.util.List;

public class View {

    private Translator translator = new Translator();

    public void setLanguage(String language) {
        translator.setLanguage(language);
    }

    public int getLength(String field) {
        return translator.getLength(field);
    }

    public String getHeaderMessage(String key) {
        return translator.getHeaderMessage(key);
    }

    public void printMenu() {
        List.of(
                getMenuMessage("menuHeader"),
                getMenuMessage("showCarParkTable"),
                getMenuMessage("showSorted"),
                getMenuMessage("showFiltered"),
                getMenuMessage("showTotalPrice"),
                getMenuMessage("exit")
        ).forEach(this::printMessage);
    }

    private String getMenuMessage(String key) {
        return translator.getMenuMessage(key);
    }

    public void printInputMessage() {
        printMessage(translator.getInputMessage("inputOperation"));
    }

    public void printWrongInputMessage() {
        printMessage(translator.getInputMessage("wrongInput"));
    }

    public void printInputTopLimitMessage() {
        printMessage(translator.getInputMessage("topLimit"));
    }

    public void printWrongTopLimitMessage(int bottomLimit) {
        printMessage(
                String.format(
                        translator.getInputMessage("wrongTopLimit"),
                        bottomLimit
                )
        );
    }

    public void printInputBottomLimitMessage() {
        printMessage(translator.getInputMessage("bottomLimit"));
    }

    public String getLabel(String key) {
        return translator.getLabel(key);
    }

    public void printTotalPrice(int price) {
        printMessage(String.format(getLabel("totalPrice"), price));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
