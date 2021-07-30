package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Rent {
    Person person;
    Vehicle vehicle;
    LocalDate startRantTime;
    LocalDate endRentTime;
}
