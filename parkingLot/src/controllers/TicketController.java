package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import enums.ResponseStatus;
import enums.VehicleType;
import exceptions.InvalidGateException;
import exceptions.NoAvailableParkingSpot;
import exceptions.NoParkingLotException;
import model.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request){
        String vehicleNo = request.getVehicleNo();
        VehicleType vehicleType = request.getVehicleType();
        Long gateId = request.getGateId();

        Ticket ticket = null;
        GenerateTicketResponseDto response = new GenerateTicketResponseDto();
        try {
            ticket = ticketService.generateTicket(vehicleNo, vehicleType, gateId);
        } catch (InvalidGateException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Invalid Gate");
            return response;
        } catch (NoAvailableParkingSpot e) {
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("No Parking slot available");
            return response;
        } catch (NoParkingLotException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("No Parking lot for given gate");
            return response;
        }


        response.setTicketId(ticket.getId());
        response.setOperatorName(ticket.getOperator().getName());
        response.setSpotNumber(ticket.getParkingSpot().getSpotNo());
        response.setResponseStatus(ResponseStatus.SUCCESS);


        return response;
    }

}
