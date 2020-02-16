package ua.kpi.carpark;

import ua.kpi.carpark.controller.Controller;
import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.view.View;

public class Main {

    public static void main(String... args) {
        View view = new View();
        Controller controller = new Controller(new CarPark(), view);
        controller.start();
    }
}
