package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Rent {
    int id;
    LocalDate startRentTime;
    LocalDate endRentTime;
    double kilometers;
    int pin;
    String registrationNumber;

}
