package example.repository;

import example.commons.TypeOfVehicle;
import example.exceptions.InvalidInput;
import example.models.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private static final String CSV_VEHICLE_FILE="src/main/resources/vehicles.csv";
 public List<Vehicle> readVehicles(){
     List<Vehicle> temp=new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(CSV_VEHICLE_FILE)))
    {
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(",");
            if (tokens.length != 5)
                throw new InvalidInput("numarul de parametri diferit de 5 pentru linia " + line);
            temp.add(new Vehicle(tokens[0], setType(tokens[1]), Integer.parseInt(tokens[2]),(tokens[3]), tokens[4]));
        }
    } catch (IOException e) {
            e.printStackTrace();
        }catch(NumberFormatException nr){
            throw new InvalidInput("anul introdus contine litere! -> "+ nr.getLocalizedMessage());
        }
     return temp;
 }



    public void writeVehicles(List<Vehicle> vehicles)  {

        try ( BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter("src/main/resources/vehicle_write.csv")))
        {
        for (Vehicle v: vehicles){
            bufferedWriter.write(v.toString());
        }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public TypeOfVehicle setType(String token) {
        return switch (token.toUpperCase()) {
            case "CAR" -> TypeOfVehicle.CAR;
            case "TRUCK" -> TypeOfVehicle.TRUCK;
            case "BUS" -> TypeOfVehicle.BUS;
            case "PLANE" -> TypeOfVehicle.PLANE;
            case "BICYCLE" -> TypeOfVehicle.BICYCLE;
            default -> throw new InvalidInput("Tipul de vehicul oferit nu este definit! -> " + token);
        };
    }

}




