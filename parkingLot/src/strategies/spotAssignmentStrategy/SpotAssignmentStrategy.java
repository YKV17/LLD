package strategies.spotAssignmentStrategy;

import enums.VehicleType;
import model.Gate;
import model.ParkingLot;
import model.ParkingSpot;

import java.util.Optional;

public interface SpotAssignmentStrategy {

    public Optional<ParkingSpot> findParkingSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate);
}
