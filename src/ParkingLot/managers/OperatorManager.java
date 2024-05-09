package ParkingLot.managers;

import ParkingLot.dtos.facadeDTOS.FacadeInsertOperatorRequestDTO;
import ParkingLot.dtos.facadeDTOS.FacadeInsertOperatorResponseDTO;
import ParkingLot.dtos.facadeDTOS.GetFacadeOperatorResponseDTO;
import ParkingLot.facades.OperatorFacade;
import ParkingLot.services.OperatorService;

import java.util.List;

public class OperatorManager {
    private OperatorFacade operatorFacade;

    public OperatorManager(OperatorService operatorService) {
        this.operatorFacade = new OperatorFacade(operatorService);
    }

    public FacadeInsertOperatorResponseDTO createOperators(FacadeInsertOperatorRequestDTO facadeInsertOperatorRequestDTO) {
        return this.operatorFacade.creatingOperator(facadeInsertOperatorRequestDTO);
    }

    public GetFacadeOperatorResponseDTO getOperators(){
        return this.operatorFacade.gettingOperators();
    }

}
