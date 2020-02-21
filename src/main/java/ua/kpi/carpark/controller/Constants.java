package ua.kpi.carpark.controller;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class Constants {

    public static final int EXIT_CODE = 0;
    public static final int ALL_CODE = 1;
    public static final int SORTED_CODE = 2;
    public static final int FILTERED_CODE = 3;
    public static final int PRICE_CODE = 4;

    public static final int MIN_OPERATION_CODE = EXIT_CODE;
    public static final int MAX_OPERATION_CODE = PRICE_CODE;

    public static final String DATA_FILE_NAME = "cars.csv";
    public static final String DATA_DELIMITER = ",";

    public static final String FILENAME_IS_NULL = "fileName should not be null";
    public static final String INPUT_STREAM_IS_NULL = "File '%s' was not found";
}
