package example.services;

import example.models.Person;
import example.models.Rent;

import java.util.List;

public interface RentService {
    List<Rent> allHistory();
    List<Rent> allRentedVehicleForAUser(Person p);
}
