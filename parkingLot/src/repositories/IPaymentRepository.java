package repositories;

import model.Payment;

public interface IPaymentRepository {
    public Payment save(Payment payment);
    public Payment getPaymentForId(Long id);
}
