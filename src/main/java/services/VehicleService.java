package services;

import commons.TypeOfVehicle;
import models.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> viewAll();
    public List<Vehicle> viewVehicleInChronologicalOrder();
    public List<Vehicle> viewVehicleSortedByBrand();
    public List<Vehicle> viewVehicleByBrand(String brand);
    public List<Vehicle> vehicleByType(TypeOfVehicle tp);
}
