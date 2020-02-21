package ua.kpi.carpark;

import ua.kpi.carpark.controller.Controller;
import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.view.Formatter;
import ua.kpi.carpark.view.View;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class Main {

    public static void main(String... args) {
        View view = new View(new Formatter());
        Controller controller = new Controller(new CarPark(), view);
        controller.start();
    }
}
