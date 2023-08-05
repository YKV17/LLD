package repositories;

import model.Gate;
import model.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository implements IParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();

    private long lastSavedId = 0L;

    public Optional<ParkingLot> findParkingLotForGate(Gate gate) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getGates().contains(gate)) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<ParkingLot> findParkingLotForId(Long id) {
        ParkingLot parkingLot = parkingLots.get(id);
        if (parkingLot != null) {
            return Optional.of(parkingLot);
        }
        return Optional.empty();
    }

    @Override
    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        long id = lastSavedId + 1;
        parkingLot.setId(id);
        parkingLots.put(id, parkingLot);
        lastSavedId = id;
        return parkingLot;
    }

    @Override
    public Boolean removeParkingLot(Long id) {
        ParkingLot removedParkingLot = parkingLots.remove(id);
        if (removedParkingLot != null) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeParkingLot(Gate gate) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getGates().contains(gate)) {
                return removeParkingLot(parkingLot.getId());
            }
        }
        return false;
    }
}
