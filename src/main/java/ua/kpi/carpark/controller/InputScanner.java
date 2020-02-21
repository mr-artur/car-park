package ua.kpi.carpark.controller;

import ua.kpi.carpark.view.Language;
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
        do {
            languageCode = inputIntValue(scanner);
            if (isIncorrectLanguageCode(languageCode)) {
                view.printTranslatedMessage(View.WRONG_INPUT);
            }
        } while (isIncorrectLanguageCode(languageCode));
        return languageCode;
    }

    private boolean isIncorrectLanguageCode(int languageCode) {
        return (languageCode < Language.ENGLISH.getCode())
                || (languageCode > Language.RUSSIAN.getCode());
    }

    private int inputIntValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            view.printTranslatedMessage(View.WRONG_INPUT);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public int selectOperation(Scanner scanner) {
        int operation;

        view.printMenu();
        view.printTranslatedMessage(View.INPUT_OPERATION);
        do {
            operation = inputIntValue(scanner);
            if (isIncorrect(operation)) {
                view.printTranslatedMessage(View.WRONG_INPUT);
            }
        } while (isIncorrect(operation));
        return operation;
    }

    private boolean isIncorrect(int operation) {
        return (operation < Constants.MIN_OPERATION_CODE)
                || (operation > Constants.MAX_OPERATION_CODE);
    }

    public int inputBottomLimit(Scanner scanner) {
        view.printTranslatedMessage(View.BOTTOM_LIMIT);
        return inputLimit(scanner);
    }

    public int inputTopLimit(Scanner scanner, int bottomLimit) {
        int topLimit;

        view.printTranslatedMessage(View.TOP_LIMIT);
        do {
            topLimit = inputLimit(scanner);
            if (topLimit < bottomLimit) {
                view.printTranslatedMessage(View.WRONG_TOP_LIMIT);
                view.printTranslatedMessage(View.TOP_LIMIT);
            }
        } while (topLimit < bottomLimit);
        return topLimit;
    }

    private int inputLimit(Scanner scanner) {
        int limit;

        do {
            limit = inputIntValue(scanner);
            if (isNegative(limit)) {
                view.printTranslatedMessage(View.WRONG_INPUT);
            }
        } while (isNegative(limit));
        return limit;
    }

    private boolean isNegative(int limit) {
        return limit < 0;
    }
}
