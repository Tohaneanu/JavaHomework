package services.impl;

import models.Vehicle;
import commons.TypeOfVehicle;
import services.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleService {
    private final List<Vehicle> vehicles=new ArrayList<>();


    public void init(){
        vehicles.add(new Vehicle("BV07TAD",TypeOfVehicle.CAR,2018,"BMW","Black"));
        vehicles.add(new Vehicle("B100MNT",TypeOfVehicle.CAR,2000,"DACIA","Red"));
        vehicles.add(new Vehicle("SB24AIS",TypeOfVehicle.TRUCK,2020,"SKODA","Black"));
        vehicles.add(new Vehicle("BV75KES",TypeOfVehicle.CAR,2016,"VOLVO","Green"));
    }


    @Override
    public List<Vehicle> viewAll() {
     return vehicles;
    }

    @Override
    public List<Vehicle> viewVehicleInChronologicalOrder() {
//        int n = vehicles.size();
//        for (int i = 0; i < n-1; i++)
//        {
//            int min_idx = i;
//            for (int j = i+1; j < n; j++)
//                if (vehicles.get(j).getManufacturingYear() < vehicles.get(min_idx).getManufacturingYear())
//                    min_idx = j;
//             Vehicle temp = vehicles.get(min_idx);
//             vehicles.remove(min_idx);
//             vehicles.add(min_idx, vehicles.get(i));
//             vehicles.remove(i);
//             vehicles.add(i,temp);
//        }
//        return vehicles;
        return vehicles.stream().sorted((v1,v2)->v1.getManufacturingYear()-v2.getManufacturingYear()).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> viewVehicleSortedByBrand() {
        return vehicles.stream().sorted((v1,v2)->v1.getBrand().compareTo(v2.getBrand())).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> viewVehicleByBrand(String brand) {
//        int n=vehicles.size();
//        List<Vehicle> result=new ArrayList<>();
//        for (int i=0;i<n;i++){
//            if (vehicles.get(i).getBrand().equals(brand))
//                result.add(vehicles.get(i));
//        }
//        return result;
        return vehicles.stream().filter(v-> v.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> vehicleByType(TypeOfVehicle tp) {
//                int n=vehicles.size();
//        List<Vehicle> result=new ArrayList<>();
//        for (int i=0;i<n;i++){
//            if (vehicles.get(i).getType().equals(tp))
//                result.add(vehicles.get(i));
//        }
//        return result;
        return vehicles.stream().filter(v->v.getType().equals(tp)).collect(Collectors.toList());
    }
}
