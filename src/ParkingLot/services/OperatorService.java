package ParkingLot.services;

import ParkingLot.models.Operator;
import ParkingLot.repositories.OperatorRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OperatorService {
    private OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Operator insertOperator(String operatorName) {
        Operator operator = new Operator();

        operator.setName(operatorName);
        operator.setCreatedAt(new Date());
        operator.setModifiedAt(new Date());

        Optional<Operator> operatorOptional =  operatorRepository.save(operator);

        if(operatorOptional.isEmpty())
                throw new RuntimeException("Error inserting operator");

        return operatorOptional.get();
    }


    public List<Operator> getOperators() {
        Optional<List<Operator>> operatorsOptional =   operatorRepository.getAll();

        if(operatorsOptional.isEmpty())
            throw new RuntimeException("Error to fetch operators");

        return operatorsOptional.get();
    }
}
