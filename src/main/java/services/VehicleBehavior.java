package services;

import otherClasses.TypeOfVehicle;
import models.Vehicle;

import java.util.List;

public interface VehicleBehavior {
    public List<Vehicle> viewVehicleInChronologicalOrder();
    public List<Vehicle> viewVehicleSortedByBrand();
    public List<Vehicle> viewVehicleByBrand(String brand);
    public List<Vehicle> vehicleByType(TypeOfVehicle tp);
}
