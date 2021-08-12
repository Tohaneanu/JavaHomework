package example;

import example.commons.TypeOfVehicle;
import example.models.History;
import example.models.Vehicle;
import example.repository.RentJDBC;
import example.services.impl.VehicleServiceImpl;

import java.util.List;
import java.util.Optional;

public class MainClass {
    public static void main(String[] args) {

        VehicleServiceImpl vehicleController=new VehicleServiceImpl();
        System.out.println();
        System.out.println("vehicle in chronological order:");
        List<Vehicle> viewVehicleInChronologicalOrder = vehicleController.viewVehicleInChronologicalOrder();
        viewVehicleInChronologicalOrder.forEach(System.out::println);
        List<Vehicle> vehicleSortedByBrand = vehicleController.viewVehicleSortedByBrand();
        System.out.println();
        System.out.println("vehicle sorted by brand:");
        vehicleSortedByBrand.forEach(System.out::println);
        List<Vehicle> skodaVehicle = vehicleController.viewVehicleByBrand("SKODA");
        System.out.println();
        System.out.println("skoda vehicles:");
        skodaVehicle.forEach(System.out::println);
        List<Vehicle> vehicleByType = vehicleController.vehicleByType(TypeOfVehicle.CAR);
        System.out.println();
        System.out.println("car vehicles:");
        vehicleByType.forEach(System.out::println);


//        System.out.println();System.out.println("citit din csv:");
//        List<Vehicle> vehicles=new VehicleRepository().readVehicles();
//        vehicles.forEach(System.out::println);
////        new VehicleRepository().writeVehicles(vehicles);


//        Rent rent=new Rent(LocalDate.of(2021,9,3),LocalDate.of(2021,12,8),50642.2,2310,"CV24AIS");
        RentJDBC rentJDBC=new RentJDBC();
//        rentJDBC.saveRent(rent);
        Optional<List<History>> rentHistory = rentJDBC.getRentHistory();
        System.out.println();
        System.out.println(rentHistory);
        int pin=2310;
        Optional<List<History>> rentVehicleByUser = rentJDBC.getRentVehicleByUser(pin);
        System.out.println("\n\n\n");
        System.out.println("                    rent vehicle for person with pin= "+pin);
        System.out.println();
        System.out.println(rentVehicleByUser);
    }
}
