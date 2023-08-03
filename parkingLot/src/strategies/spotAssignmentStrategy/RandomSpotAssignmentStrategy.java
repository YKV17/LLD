package strategies.spotAssignmentStrategy;

import enums.SpotStatus;
import enums.VehicleType;
import model.Gate;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public Optional<ParkingSpot> findParkingSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) {

        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE
                && parkingSpot.getVehicleTypes().contains(vehicleType)){
                    return Optional.of(parkingSpot);
                }
            }
        }

        return Optional.empty();
    }
}
