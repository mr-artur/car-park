package ua.kpi.carpark.view;

public enum CarTableColumn {
    NUMBER("number"),
    MODEL("model"),
    PRICE("price"),
    MAX_SPEED("max.speed"),
    COMFORT_LEVEL("comfort.level"),
    FUEL_COST("fuel.cost"),
    TARIFF_COST("tariff.cost");

    public static final String PREFIX = "output.header.";
    public static final String LENGTH = "length.";
    private final String key;

    CarTableColumn(String key) {
        this.key = key;
    }

    public String getKey() {
        return PREFIX + key;
    }

    public String getLength() {
        return PREFIX + LENGTH + key;
    }
}
