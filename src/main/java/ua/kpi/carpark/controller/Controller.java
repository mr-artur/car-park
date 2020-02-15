package ua.kpi.carpark.controller;

import ua.kpi.carpark.model.CarPark;
import ua.kpi.carpark.model.car.BusinessCar;
import ua.kpi.carpark.model.car.ComfortCar;
import ua.kpi.carpark.model.car.EconomCar;
import ua.kpi.carpark.view.View;

public class Controller {

    private CarPark carPark;
    private OutputPrinter printer;

    public Controller(CarPark carPark, View view) {
        this.carPark = carPark;
        this.printer = new OutputPrinter(view);
    }

    public void start() {
        carPark.addCar(new BusinessCar("KIA", 2.3, 25000, 135));
        carPark.addCar(new ComfortCar("Mitsubishi", 3.5, 10000, 500));
        carPark.addCar(new EconomCar("Economy shit", 2.2, 4000, 100));
        printer.printCarsTable(carPark.getCars());
        printer.printCarsTable(carPark.getSortedByConsumption());
    }
}
