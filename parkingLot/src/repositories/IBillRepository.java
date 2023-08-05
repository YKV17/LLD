package repositories;

import model.Bill;

import java.util.Optional;

public interface IBillRepository {
    public Bill save(Bill bill);
    public Optional<Bill> getBillForId(Long id);
    public Optional<Bill> getBillForTicketId(Long ticketId);
}
