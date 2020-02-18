package ua.kpi.carpark.model.car;

public enum ComfortLevel {

    ECONOMY(1),
    STANDARD(1.2),
    COMFORT(1.4),
    BUSINESS(2),
    UNIVERSAL(2.2);

    private final double coefficient;

    ComfortLevel(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
