package ParkingLot.controllers;

import ParkingLot.dtos.*;
import ParkingLot.models.ParkingLot;
import ParkingLot.services.ParkingLotService;

import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public InsertParkingLotResponseDTO insertParkingLot(InsertParkingLotRequestDTO insertParkingLotRequestDTO){

        InsertParkingLotResponseDTO responseDTO = new InsertParkingLotResponseDTO();

        try {
             ParkingLot savedParkingLot =   parkingLotService.insertParkingLot(
                     insertParkingLotRequestDTO.getCapacity(),
                     insertParkingLotRequestDTO.getParkingLotStatus(),
                     insertParkingLotRequestDTO.getVehicleTypeList(),
                     insertParkingLotRequestDTO.getSlotAssignmentStrategyType()
             );

            responseDTO.setParkingLot(savedParkingLot);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDTO;
        }catch (Exception exception){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setFailureMessage(exception.getMessage());
            return responseDTO;
        }

    }

    public GetParkingLotResponseDTO getParkingLot() {
        GetParkingLotResponseDTO getParkingLotResponseDTO = new GetParkingLotResponseDTO();

        try{
            List<ParkingLot> parkingLots = parkingLotService.getParkingLots();
            getParkingLotResponseDTO.setParkingLots(parkingLots);
            getParkingLotResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return getParkingLotResponseDTO;
        }catch (Exception exception){
            getParkingLotResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            getParkingLotResponseDTO.setFailureMessage(exception.getMessage());
            return getParkingLotResponseDTO;
        }
    }
}
