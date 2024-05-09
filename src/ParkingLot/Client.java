package ParkingLot;


import ParkingLot.dtos.*;
import ParkingLot.dtos.facadeDTOS.FacadeInsertOperatorRequestDTO;
import ParkingLot.dtos.facadeDTOS.FacadeInsertOperatorResponseDTO;
import ParkingLot.dtos.facadeDTOS.GetFacadeOperatorResponseDTO;
import ParkingLot.managers.OperatorManager;
import ParkingLot.models.*;
import ParkingLot.repositories.*;
import ParkingLot.services.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        //................................  OPERATOR operations.........................................

        //*****************************Creating Operators record in MAP TABLE***************************
        OperatorRepository operatorRepository = new OperatorRepository();
        OperatorService operatorService = new OperatorService(operatorRepository);

        OperatorManager operatorManager = new OperatorManager(operatorService);

        List<String> operators = new ArrayList<>(Arrays.asList("Ramesh", "Vinod", "Rakesh", "Sanjay"));
        FacadeInsertOperatorRequestDTO facadeInsertOperatorRequestDTO = new FacadeInsertOperatorRequestDTO();
        facadeInsertOperatorRequestDTO.setOperatorNames(operators);

        FacadeInsertOperatorResponseDTO facadeInsertOperatorResponseDTO = operatorManager.createOperators(facadeInsertOperatorRequestDTO);

        if(facadeInsertOperatorResponseDTO.getResponseStatus().equals(ResponseStatus.FAILURE) ) {
            System.out.println("Failure Message : " + facadeInsertOperatorResponseDTO.getMessage() + "s:");
            int failedIndex = facadeInsertOperatorResponseDTO.getCurrentIndex();

            for(int i=failedIndex+1; i<operators.size(); i++) {
                System.out.println(operators.get(i));
            }

            return;
        }

        System.out.println(facadeInsertOperatorResponseDTO.getMessage());
        //******************************End Creating Operators record in MAP TABLE********************


        //*******************************Fetching Operators record from MAP TABLE*********************
        GetFacadeOperatorResponseDTO getFacadeOperatorResponseDTO = operatorManager.getOperators();

        if(getFacadeOperatorResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            List<Operator> getOperators = getFacadeOperatorResponseDTO.getOperators();
            for (Operator operator : getOperators) {
                System.out.println("Operator Name : " + operator.getName());
                System.out.println("Operator Emp ID : " + operator.getEmpId());
                System.out.println("Operator Created At : " + operator.getCreatedAt());
                System.out.println("Operator Modified At : " + operator.getModifiedAt());
                System.out.println("--------------------------------------");
            }
        }else{
            System.out.println("Failure Message : " + getFacadeOperatorResponseDTO.getMessage());
        }
        //********************************End Fetching Operators record from MAP TABLE**************************

        //.......................................End OPERATOR operations........................................
    }
}


// Issue token
// GenerateBill : Please implement this

// Controllers
// Services
// Repositories

// x -> y -> z
// Topological sorting

