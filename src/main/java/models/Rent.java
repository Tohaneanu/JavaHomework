package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import otherClasses.Date;

@AllArgsConstructor
@Getter
@Setter
public class Rent {
    Person person;
    Vehicle vehicle;
    Date startRantTime;
    Date endRentTime;
}
