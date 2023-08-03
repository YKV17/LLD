package repositories;

import model.Vehicle;

import java.util.Optional;

public interface IVehicleRepository {
    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber);

    public Vehicle save(Vehicle vehicle);
}
