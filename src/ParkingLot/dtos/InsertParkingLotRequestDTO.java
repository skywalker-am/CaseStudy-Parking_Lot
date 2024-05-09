package ParkingLot.dtos;

import ParkingLot.models.ParkingLotStatus;
import ParkingLot.models.SlotAssignmentStrategyType;
import ParkingLot.models.VehicleType;

import java.util.List;

public class InsertParkingLotRequestDTO {
    private int capacity;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> vehicleTypeList;
    private SlotAssignmentStrategyType slotAssignmentStrategyType;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public SlotAssignmentStrategyType getSlotAssignmentStrategyType() {
        return slotAssignmentStrategyType;
    }

    public void setSlotAssignmentStrategyType(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        this.slotAssignmentStrategyType = slotAssignmentStrategyType;
    }
}
