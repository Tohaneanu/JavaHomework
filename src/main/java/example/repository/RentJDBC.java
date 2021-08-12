package example.repository;

import example.models.History;
import example.models.Person;
import example.models.Rent;
import example.models.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentJDBC {
    public void saveRent(Rent rent) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_homework", "root", "02062019");

            ps = conn.prepareStatement("insert into rent(start_rent_time,end_rent_time,kilometers,pin,registration_number) values(?,?,?,?,?)");
            ps.setDate(1, Date.valueOf(rent.getStartRentTime()));
            ps.setDate(2, Date.valueOf(rent.getEndRentTime()));
            ps.setDouble(3, rent.getKilometers());
            ps.setInt(4, rent.getPin());
            ps.setString(5, rent.getRegistrationNumber());

            ps.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public Optional<List<History>> getRentHistory() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_homework", "root", "02062019");
             PreparedStatement ps = conn.prepareStatement("Select * from rent r join vehicle v on v.registration_number=r.registration_number join person p on p.pin=r.pin");) {
            List<History> histories = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle(rs.getString("registration_number"), new VehicleRepository().setType(rs.getString("type_of")), rs.getInt("manufacturing_year"), rs.getString("brand"), rs.getString("color"));
                    Person person = new Person(rs.getInt("pin"),rs.getString("first_name"),rs.getString("last_name"),rs.getDate("birthday").toLocalDate(), rs.getString("gender").charAt(0), rs.getDate("issuing_year_of_driving_license").toLocalDate());
                    Rent rent = new Rent(rs.getDate("start_rent_time").toLocalDate(),rs.getDate("end_rent_time").toLocalDate(),rs.getDouble("kilometers"),rs.getInt("pin"),rs.getString("registration_number"));

                    History history = new History(vehicle, person, rent);
                    histories.add(history);
                }
                return histories.isEmpty() ? Optional.empty() : Optional.of(histories);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<List<History>> getRentVehicleByUser(int personPin) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_homework", "root", "02062019");
             PreparedStatement ps = conn.prepareStatement("Select * from rent r join vehicle v on v.registration_number=r.registration_number join person p on p.pin=r.pin where p.pin=?");) {
            ps.setInt(1,personPin);
            List<History> histories = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle(rs.getString("registration_number"), new VehicleRepository().setType(rs.getString("type_of")), rs.getInt("manufacturing_year"), rs.getString("brand"), rs.getString("color"));
                    Person person = new Person(rs.getInt("pin"),rs.getString("first_name"),rs.getString("last_name"),rs.getDate("birthday").toLocalDate(), rs.getString("gender").charAt(0), rs.getDate("issuing_year_of_driving_license").toLocalDate());
                    Rent rent = new Rent(rs.getDate("start_rent_time").toLocalDate(),rs.getDate("end_rent_time").toLocalDate(),rs.getDouble("kilometers"),rs.getInt("pin"),rs.getString("registration_number"));

                    History history = new History(vehicle, person, rent);
                    histories.add(history);
                }
                return histories.isEmpty() ? Optional.empty() : Optional.of(histories);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return Optional.empty();
    }
}
