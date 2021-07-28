package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import otherClasses.TypeOfVehicle;


@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    String registrationNumber;
    TypeOfVehicle type;
    int manufacturingYear;
    String brand;
    String color;

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", type=" + type +
                ", manufacturingYear=" + manufacturingYear +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
