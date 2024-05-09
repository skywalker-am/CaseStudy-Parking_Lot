package ParkingLot.repositories;

import ParkingLot.models.Operator;

import java.util.*;

public class OperatorRepository {
    private Map<Long, Operator> operators = new TreeMap<>();
    private Long id = 0L;

    public Optional<Operator> save(Operator operator) {
        id +=  1;

        operator.setId(id);
        operator.setEmpId(id);
        operators.put(id, operator);

        if(operators.containsKey(id)){
            return Optional.of(operators.get(id));
        }

        return Optional.empty();
    }

    public Optional<List<Operator>> getAll() {

        if(!operators.isEmpty()){
            return Optional.of(new ArrayList<>(operators.values()));

        }

        return Optional.empty();
    }
}
