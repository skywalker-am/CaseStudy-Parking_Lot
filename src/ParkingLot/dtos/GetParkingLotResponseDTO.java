package ParkingLot.dtos;

import ParkingLot.models.Operator;
import ParkingLot.models.ParkingLot;

import java.util.List;

public class GetParkingLotResponseDTO {
    private List<ParkingLot> parkingLots;
    private ResponseStatus responseStatus;
    private String failureMessage;

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
