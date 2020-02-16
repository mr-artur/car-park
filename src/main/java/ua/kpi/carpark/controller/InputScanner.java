package ua.kpi.carpark.controller;

import ua.kpi.carpark.view.View;

import java.util.Scanner;

public class InputScanner {

    private final View view;

    public InputScanner(View view) {
        this.view = view;
    }

    public int selectLanguage(Scanner scanner) {
        int languageCode;

        view.printLanguageMenu();
        view.printInputMessage(Constants.MIN_LANGUAGE_CODE,
                Constants.MAX_LANGUAGE_CODE);
        do {
            languageCode = inputIntValue(scanner);
            if (isIncorrectLanguageCode(languageCode)) {
                view.printWrongInputMessage();
            }
        } while (isIncorrectLanguageCode(languageCode));
        return languageCode;
    }

    private boolean isIncorrectLanguageCode(int languageCode) {
        return (languageCode < Constants.MIN_LANGUAGE_CODE)
                || (languageCode > Constants.MAX_LANGUAGE_CODE);
    }

    private int inputIntValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            view.printWrongInputMessage();
            scanner.next();
        }
        return scanner.nextInt();
    }

    public int selectOperation(Scanner scanner) {
        int operation;

        view.printMenu();
        view.printInputMessage(Constants.MIN_OPERATION_CODE,
                Constants.MAX_OPERATION_CODE);
        do {
            operation = inputIntValue(scanner);
            if (isIncorrect(operation)) {
                view.printWrongInputMessage();
            }
        } while (isIncorrect(operation));
        return operation;
    }

    private boolean isIncorrect(int operation) {
        return (operation < Constants.MIN_OPERATION_CODE)
                || (operation > Constants.MAX_OPERATION_CODE);
    }

    public int inputBottomLimit(Scanner scanner) {
        view.printInputBottomLimitMessage();
        return inputLimit(scanner);
    }

    public int inputTopLimit(Scanner scanner, int bottomLimit) {
        int topLimit;

        view.printInputTopLimitMessage();
        do {
            topLimit = inputLimit(scanner);
            if (topLimit < bottomLimit) {
                view.printWrongTopLimitMessage(bottomLimit);
                view.printInputTopLimitMessage();
            }
        } while (topLimit < bottomLimit);
        return topLimit;
    }

    private int inputLimit(Scanner scanner) {
        int limit;

        do {
            limit = inputIntValue(scanner);
            if (isNegative(limit)) {
                view.printWrongInputMessage();
            }
        } while (isNegative(limit));
        return limit;
    }

    private boolean isNegative(int limit) {
        return limit < 0;
    }
}
