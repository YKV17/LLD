package repositories;

import model.Ticket;
import model.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository implements IVehicleRepository{

    private Map<Long, Vehicle> vehicles = new TreeMap<>();

    private Long lastSavedId = 0L;

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber){
        for(Vehicle vehicle: vehicles.values()){
            if(vehicle.getVehicleNo().equals(vehicleNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        long id = lastSavedId + 1;
        vehicle.setId(id);
        vehicles.put(id, vehicle);
        return vehicle;
    }
}
