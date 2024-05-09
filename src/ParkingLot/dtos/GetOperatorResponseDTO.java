package ParkingLot.dtos;

import ParkingLot.models.Operator;

import java.util.List;

public class GetOperatorResponseDTO {
    private List<Operator> operators;
    private ResponseStatus responseStatus;
    private String message;

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
