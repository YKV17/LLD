package repositories;

import model.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository implements IGateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();

    private Long lastSavedId = 0L;

    public Optional<Gate> findGateById(Long gateId) {
        if (gates.containsKey(gateId)) {
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }

    @Override
    public Gate addGate(Gate gate) {
        long id = lastSavedId + 1;
        gate.setId(id);
        gates.put(id, gate);
        lastSavedId = id;
        return gate;
    }

    @Override
    public Boolean removeGate(Long id) {
        Gate gate = gates.remove(id);
        if (gate != null) {
            return true;
        }
        return false;
    }
}
