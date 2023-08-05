package repositories;

import model.Bill;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BillRepository implements IBillRepository{

    private Map<Long, Bill> bills = new TreeMap<>();

    private Long lastSavedId = 0L;

    @Override
    public Bill save(Bill bill) {
        long id = lastSavedId + 1;
        bill.setId(id);
        bills.put(id, bill);
        return bill;
    }

    @Override
    public Optional<Bill> getBillForId(Long id) {
        Bill bill = bills.get(id);
        if(bill != null){
            return Optional.of(bill);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Bill> getBillForTicketId(Long ticketId) {
        for(Bill bill: bills.values()){
            if(bill.getTicket().getId() == ticketId){
                return Optional.of(bill);
            }
        }
        return Optional.empty();
    }
}
