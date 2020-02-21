package ua.kpi.carpark.controller;

public class Constants {

    public static final int EXIT_CODE = 0;
    public static final int FIRST_OPERATION_CODE = 1;
    public static final int SECOND_OPERATION_CODE = 2;
    public static final int THIRD_OPERATION_CODE = 3;
    public static final int FOURTH_OPERATION_CODE = 4;
    public static final int MIN_OPERATION_CODE = EXIT_CODE;
    public static final int MAX_OPERATION_CODE = FOURTH_OPERATION_CODE;


    public static final String NUMBER_FIELD = "number";
    public static final String MODEL_FIELD = "model";
    public static final String CONSUMPTION_FIELD = "consumption";
    public static final String PRICE_FIELD = "price";
    public static final String MAX_SPEED_FIELD = "maxSpeed";
    public static final String COMFORT_LEVEL_FIELD = "comfortLevel";

    public static final String DATA_FILE_NAME = "cars.csv";
    public static final String DATA_DELIMITER = ",";

    public static final String FILENAME_IS_NULL = "fileName should not be null";
    public static final String INPUT_STREAM_IS_NULL = "File '%s' was not found";

    public static final String[] fields = {
            NUMBER_FIELD,
            MODEL_FIELD,
            CONSUMPTION_FIELD,
            PRICE_FIELD,
            MAX_SPEED_FIELD,
            COMFORT_LEVEL_FIELD
    };
}
