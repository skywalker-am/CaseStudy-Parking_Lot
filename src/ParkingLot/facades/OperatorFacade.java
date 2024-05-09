package ParkingLot.facades;

import ParkingLot.controllers.OperatorController;
import ParkingLot.dtos.GetOperatorResponseDTO;
import ParkingLot.dtos.InsertOperatorRequestDTO;
import ParkingLot.dtos.InsertOperatorResponseDTO;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.dtos.facadeDTOS.FacadeInsertOperatorRequestDTO;
import ParkingLot.dtos.facadeDTOS.FacadeInsertOperatorResponseDTO;
import ParkingLot.dtos.facadeDTOS.GetFacadeOperatorResponseDTO;
import ParkingLot.models.Operator;
import ParkingLot.services.OperatorService;

import java.util.List;

public class OperatorFacade {
    private OperatorService operatorService;

    public OperatorFacade(OperatorService operatorService){
        this.operatorService = operatorService;
    }

    public FacadeInsertOperatorResponseDTO creatingOperator(FacadeInsertOperatorRequestDTO facadeInsertOperatorRequestDTO){
        //*****************************Creating Operators record in MAP TABLE***************************

        OperatorController operatorController = new OperatorController(this.operatorService);
        InsertOperatorRequestDTO insertOperatorRequestDTO = new InsertOperatorRequestDTO();
        FacadeInsertOperatorResponseDTO facadeInsertOperatorResponseDTO = new FacadeInsertOperatorResponseDTO();

        List<String> operators = facadeInsertOperatorRequestDTO.getOperatorNames();

        for(String operator : operators){
            insertOperatorRequestDTO.setOperatorName(operator);
            InsertOperatorResponseDTO insertOperatorResponseDTO  = operatorController.insertOperator(insertOperatorRequestDTO);

            if(insertOperatorResponseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
                facadeInsertOperatorResponseDTO.setCurrentIndex(operators.indexOf(operator));
                facadeInsertOperatorResponseDTO.setResponseStatus(insertOperatorResponseDTO.getResponseStatus());
                facadeInsertOperatorResponseDTO.setMessage(insertOperatorResponseDTO.getFailureMessage());
                facadeInsertOperatorResponseDTO.setCurrentUnsavedOperator(insertOperatorResponseDTO.getOperator());

                return facadeInsertOperatorResponseDTO;
            }
        }

        facadeInsertOperatorResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        facadeInsertOperatorResponseDTO.setMessage("Operators are inserted successfully!");

        return facadeInsertOperatorResponseDTO;
        //******************************End Creating Operators record in MAP TABLE********************
    }

    public GetFacadeOperatorResponseDTO gettingOperators(){
        //*******************************Fetching Operators record from MAP TABLE*********************

        OperatorController operatorController = new OperatorController(this.operatorService);
        GetFacadeOperatorResponseDTO getFacadeOperatorResponseDTO = new GetFacadeOperatorResponseDTO();

        GetOperatorResponseDTO getOperatorResponseDTO  = operatorController.getOperators();

        if (getOperatorResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            getFacadeOperatorResponseDTO.setOperators(getOperatorResponseDTO.getOperators());
        }

        getFacadeOperatorResponseDTO.setResponseStatus(getOperatorResponseDTO.getResponseStatus());
        getFacadeOperatorResponseDTO.setMessage(getOperatorResponseDTO.getMessage());

        return getFacadeOperatorResponseDTO;

        //********************************End Fetching Operators record from MAP TABLE**************************
    }
}
