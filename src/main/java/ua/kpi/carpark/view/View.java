package ua.kpi.carpark.view;

import java.util.Locale;

public class View {

    public void changeLanguage(String language) {
        Locale.setDefault(new Locale(language));
    }

    public void printMenu() {
        printMessage("It is menu : 0, 1, 2, 3, 4");
    }

    public void printInputMessage() {
        printMessage("Input value :");
    }

    public void printWrongInputMessage() {
        printMessage("Wrong Input! Try again");
    }

    public void printInputTopLimitMessage() {
        printMessage("Input top limit :");
    }

    public void printWrongTopLimitMessage(int bottomLimit) {
        printMessage("Wrong top limit! Should be less than " + bottomLimit);
    }

    public void printInputBottomLimitMessage() {
        printMessage("Input bottom limit :");
    }

    public void printTotalPrice(int price) {
        printMessage(String.format("Total price: %d", price));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
