package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.view.View;

public class Controller {

    private CarPark carPark;

    public Controller(CarPark carPark, View view) {
        this.carPark = carPark;
    }

    public void start() {
    }
}
