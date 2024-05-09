package ParkingLot.dtos.facadeDTOS;

import ParkingLot.dtos.ResponseStatus;
import ParkingLot.models.Operator;

public class FacadeInsertOperatorResponseDTO {
    private ResponseStatus responseStatus;
    private String message;
    private Operator currentUnsavedOperator;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    private int currentIndex;

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

    public Operator getCurrentUnsavedOperator() {
        return currentUnsavedOperator;
    }

    public void setCurrentUnsavedOperator(Operator currentUnsavedOperator) {
        this.currentUnsavedOperator = currentUnsavedOperator;
    }
}
