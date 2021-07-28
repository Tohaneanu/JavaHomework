package services;

import models.Person;
import models.Rent;

import java.util.List;

public interface RentBehavior {
    List<Rent> allHistory();
    List<Rent> allRentedVehicleForAUser(Person p);
}
