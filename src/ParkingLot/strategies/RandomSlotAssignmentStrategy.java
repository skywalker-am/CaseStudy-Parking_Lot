package ParkingLot.strategies;

import ParkingLot.models.*;

import java.util.Optional;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy {

    @Override
    public Optional<ParkingSlot> getSlot(ParkingLot parkingLot, VehicleType vehicleType){

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for (ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
               if (parkingSlot.getSupportedVehicleTypes().contains(vehicleType) && parkingSlot.getSlotStatus().equals(SlotStatus.EMPTY)) {
                   return Optional.of(parkingSlot);
               }
           }
        }

        return Optional.empty();

    }
}
