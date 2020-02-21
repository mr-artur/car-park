package ua.kpi.carpark.model.car;

import java.math.BigDecimal;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public enum ComfortLevel {

    ECONOMY(BigDecimal.valueOf(1)),
    STANDARD(BigDecimal.valueOf(1.2)),
    COMFORT(BigDecimal.valueOf(1.4)),
    BUSINESS(BigDecimal.valueOf(2)),
    UNIVERSAL(BigDecimal.valueOf(2.2));

    /**
     * Coefficient to multiply on tariff depending on comfort level
     */
    private final BigDecimal coefficient;

    ComfortLevel(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }
}
