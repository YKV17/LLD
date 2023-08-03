package services;

import enums.VehicleType;
import exceptions.InvalidGateException;
import exceptions.NoAvailableParkingSpot;
import exceptions.NoParkingLotException;
import model.*;
import repositories.*;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.time.LocalDateTime;
import java.util.Optional;

public class TicketService {

    private IGateRepository gateRepository;
    private IVehicleRepository vehicleRepository;
    private ITicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private IParkingLotRepository parkingLotRepository;

    public TicketService(IGateRepository gateRepository,
                         IVehicleRepository vehicleRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ITicketRepository ticketRepository,
                         IParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(String vehicleNumber,
                                 VehicleType vehicleType,
                                 Long gateId)
            throws InvalidGateException,
            NoAvailableParkingSpot,
            NoParkingLotException {
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if (gateOptional.isEmpty()) {
            throw new InvalidGateException();
        }
        Gate gate = gateOptional.get();
        Operator operator = gate.getOperator();

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if (vehicleOptional.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setVehicleNo(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);

        } else {
            vehicle = vehicleOptional.get();
        }

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findParkingLotForGate(gate);
        if (parkingLotOptional.isEmpty()) {
            throw new NoParkingLotException();
        }

        ParkingLot parkingLot = parkingLotOptional.get();

        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategy.findParkingSpot(vehicleType, parkingLot, gate);

        if (parkingSpotOptional.isEmpty()) {
            throw new NoAvailableParkingSpot();
        }

        ParkingSpot parkingSpot = parkingSpotOptional.get();

        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setGate(gate);
        ticket.setDateTime(LocalDateTime.now());
        ticket.setVehicle(vehicle);
        ticket.setOperator(operator);

        return ticketRepository.save(ticket);
    }
}
