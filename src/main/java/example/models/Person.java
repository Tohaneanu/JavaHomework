package example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    int pin;
    String firstName;
    String lastName;
    LocalDate birthday;
    char gender;
    LocalDate issuingYearOfDrivingLicense;

    @Override
    public String toString() {
        return "Person{" +
                "pin=" + pin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", issuingYearOfDrivingLicense=" + issuingYearOfDrivingLicense +
                '}';
    }
}
