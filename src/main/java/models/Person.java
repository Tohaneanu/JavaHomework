package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import otherClasses.Date;


@Getter
@Setter
@AllArgsConstructor
public class Person {
    int pin;
    String firstName;
    String lastName;
    Date birthday;
    char gender;
    Date issuingYearOfDrivingLicense;

}
