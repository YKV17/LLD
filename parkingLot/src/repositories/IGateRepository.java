package repositories;

import model.Gate;

import java.util.Optional;

public interface IGateRepository {
    public Optional<Gate> findGateById(Long gateId);
}
