import services.impl.VehicleServiceImpl;
import models.Vehicle;
import commons.TypeOfVehicle;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        VehicleServiceImpl vehicleController=new VehicleServiceImpl();
        vehicleController.init();
        List<Vehicle> viewVehicleInChronologicalOrder = vehicleController.viewVehicleInChronologicalOrder();
        viewVehicleInChronologicalOrder.forEach(System.out::println);
        List<Vehicle> vehicleSortedByBrand = vehicleController.viewVehicleSortedByBrand();
        System.out.println();
        vehicleSortedByBrand.forEach(System.out::println);
        List<Vehicle> skodaVehicle = vehicleController.viewVehicleByBrand("SKODA");
        System.out.println();
        skodaVehicle.forEach(System.out::println);
        List<Vehicle> vehicleByType = vehicleController.vehicleByType(TypeOfVehicle.CAR);
        System.out.println();
        vehicleByType.forEach(System.out::println);
    }
}
