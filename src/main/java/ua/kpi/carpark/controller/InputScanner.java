package ua.kpi.carpark.controller;

import ua.kpi.carpark.view.Language;
import ua.kpi.carpark.view.View;
import ua.kpi.carpark.view.ViewConstants;

import java.util.Scanner;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class InputScanner {

    private final View view;

    public InputScanner(View view) {
        this.view = view;
    }

    /**
     * Forces user to input code of language
     *
     * @param scanner scanner to read user's input
     * @return code of chosen language
     */
    public int selectLanguage(Scanner scanner) {
        int code;

        view.printLanguageMenu();
        while (true) {
            code = inputIntValue(scanner);
            if (isCorrectLanguageCode(code)) {
                break;
            }
            view.printTranslatedMessage(ViewConstants.WRONG_INPUT);
        }
        return code;
    }

    private int inputIntValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            view.printTranslatedMessage(ViewConstants.WRONG_INPUT);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private boolean isCorrectLanguageCode(int code) {
        return (code >= Language.MIN_CODE)
                || (code <= Language.MAX_CODE);
    }

    /**
     * Forces user to input code of operation
     *
     * @param scanner scanner to read user's input
     * @return code of operation
     */
    public int selectOperation(Scanner scanner) {
        int operation;

        view.printTranslatedMessage(ViewConstants.MENU);
        view.printTranslatedMessage(ViewConstants.INPUT_OPERATION);
        while (true) {
            operation = inputIntValue(scanner);
            if (isCorrect(operation)) {
                break;
            }
            view.printTranslatedMessage(ViewConstants.WRONG_INPUT);
        }
        return operation;
    }

    private boolean isCorrect(int operation) {
        return (operation >= Constants.MIN_OPERATION_CODE)
                && (operation <= Constants.MAX_OPERATION_CODE);
    }

    /**
     * Forces user to input bottom limit
     *
     * @param scanner scanner to read user's input
     * @return bottom limit
     */
    public int inputBottomLimit(Scanner scanner) {
        view.printTranslatedMessage(ViewConstants.BOTTOM_LIMIT);
        return inputLimit(scanner);
    }

    private int inputLimit(Scanner scanner) {
        int limit;

        while (true) {
            limit = inputIntValue(scanner);
            if (NotLessThanZero(limit)) {
                break;
            }
            view.printTranslatedMessage(ViewConstants.WRONG_INPUT);
        }
        return limit;
    }

    /**
     * Forces user to input top limit
     *
     * @param scanner     scanner to read user's input
     * @param bottomLimit bottom limit for checking top limit's correctness
     * @return top limit
     */
    public int inputTopLimit(Scanner scanner, int bottomLimit) {
        int topLimit;

        view.printTranslatedMessage(ViewConstants.TOP_LIMIT);
        while (true) {
            topLimit = inputLimit(scanner);
            if (topLimit >= bottomLimit) {
                break;
            }
            view.printTranslatedMessage(ViewConstants.WRONG_TOP_LIMIT);
            view.printTranslatedMessage(ViewConstants.TOP_LIMIT);
        }
        return topLimit;
    }

    private boolean NotLessThanZero(int limit) {
        return limit >= 0;
    }
}
