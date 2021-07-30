package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class Person {
    int pin;
    String firstName;
    String lastName;
    LocalDate birthday;
    char gender;
    LocalDate issuingYearOfDrivingLicense;

}
