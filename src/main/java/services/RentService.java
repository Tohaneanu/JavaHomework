package services;

import models.Person;
import models.Rent;

import java.util.List;

public interface RentService {
    List<Rent> allHistory();
    List<Rent> allRentedVehicleForAUser(Person p);
}
