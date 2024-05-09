package ParkingLot.controllers;

import ParkingLot.dtos.InsertOperatorRequestDTO;
import ParkingLot.dtos.InsertOperatorResponseDTO;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.dtos.GetOperatorResponseDTO;
import ParkingLot.models.Operator;
import ParkingLot.services.OperatorService;

import java.util.List;

public class OperatorController {
    private OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }


    public InsertOperatorResponseDTO insertOperator(InsertOperatorRequestDTO insertOperatorRequestDTO) {

        InsertOperatorResponseDTO responseDTO = new InsertOperatorResponseDTO();

        try{
            Operator savedOperator = operatorService.insertOperator(insertOperatorRequestDTO.getOperatorName());
            responseDTO.setOperator(savedOperator);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDTO;
        }catch (Exception exception){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setFailureMessage(exception.getMessage());
            return responseDTO;
        }
    }

    public GetOperatorResponseDTO getOperators() {
        GetOperatorResponseDTO getOperatorResponseDTO = new GetOperatorResponseDTO();

        try{
            List<Operator> getSavedOperators = operatorService.getOperators();
            getOperatorResponseDTO.setOperators(getSavedOperators);
            getOperatorResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return getOperatorResponseDTO;
        }catch (Exception exception){
            getOperatorResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            getOperatorResponseDTO.setMessage(exception.getMessage());
            return getOperatorResponseDTO;
        }

    }
}
