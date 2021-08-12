package example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Rent {
    LocalDate startRentTime;
    LocalDate endRentTime;
    double kilometers;
    int pin;
    String registrationNumber;

    @Override
    public String toString() {
        return "Rent{" +
                "startRentTime=" + startRentTime +
                ", endRentTime=" + endRentTime +
                ", kilometers=" + kilometers +
                ", pin=" + pin +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
