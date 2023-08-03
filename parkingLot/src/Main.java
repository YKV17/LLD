import controllers.TicketController;
import repositories.*;
import services.TicketService;
import strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        IGateRepository gateRepository = new GateRepository();
        IParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        IVehicleRepository vehicleRepository = new VehicleRepository();
        ITicketRepository ticketRepository = new TicketRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, spotAssignmentStrategy, ticketRepository, parkingLotRepository);
        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application has started");
    }
}