package ParkingLot.dtos.facadeDTOS;

import java.util.List;

public class FacadeInsertOperatorRequestDTO {
    private List<String> operatorNames;

    public List<String> getOperatorNames() {
        return operatorNames;
    }

    public void setOperatorNames(List<String> operatorNames) {
        this.operatorNames = operatorNames;
    }
}
