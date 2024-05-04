package ParkingLot.strategies;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.VehicleType;

import java.util.Optional;

public interface SlotAssignmentStrategy {
    public Optional<ParkingSlot> getSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
