package example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class History {
    Vehicle vehicle;
    Person person;
    Rent rent;

    @Override
    public String toString() {
        return "\n                  HISTORY{" +
                "\n VEHICLE=" + vehicle +
                ", \n PERSON=" + person +
                ", \n RENT=" + rent +
                "}\n\n";
    }
}
