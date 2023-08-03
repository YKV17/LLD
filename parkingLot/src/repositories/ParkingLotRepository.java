package repositories;

import model.Gate;
import model.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository implements IParkingLotRepository{

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();
    public Optional<ParkingLot> findParkingLotForGate(Gate gate){
        for(ParkingLot parkingLot: parkingLots.values()){
            if(parkingLot.getGates().contains(gate)){
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
