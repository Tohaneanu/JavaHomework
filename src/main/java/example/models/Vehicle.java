package example.models;

import example.commons.TypeOfVehicle;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Vehicle {
    String registrationNumber;
    TypeOfVehicle type;
    int manufacturingYear;
    String brand;
    String color;

    public Vehicle(String registrationNumber, TypeOfVehicle type, int manufacturingYear, String brand, String color) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        if (manufacturingYear < 1900)
            this.manufacturingYear = 1900;
        else this.manufacturingYear = Math.min(manufacturingYear, 2021);
        this.brand = brand;
        this.color = color;
    }

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
