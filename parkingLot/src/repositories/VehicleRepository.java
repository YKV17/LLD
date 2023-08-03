package repositories;

import model.Vehicle;

import java.util.Optional;

public class VehicleRepository implements IVehicleRepository{

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber){
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        return null;
    }
}
