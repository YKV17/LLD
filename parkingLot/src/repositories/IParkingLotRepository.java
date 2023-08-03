package repositories;

import model.Gate;
import model.ParkingLot;

import java.util.Optional;

public interface IParkingLotRepository{
    public Optional<ParkingLot> findParkingLotForGate(Gate gate);
}
