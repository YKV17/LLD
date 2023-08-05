package repositories;

import model.Gate;
import model.ParkingLot;

import java.util.Optional;

public interface IParkingLotRepository{
    public Optional<ParkingLot> findParkingLotForGate(Gate gate);
    public Optional<ParkingLot> findParkingLotForId(Long id);
    public ParkingLot addParkingLot(ParkingLot parkingLot);
    public Boolean removeParkingLot(Long id);
    public Boolean removeParkingLot(Gate gate);
}
