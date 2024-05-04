package ParkingLot.strategies;

import ParkingLot.models.SlotAssignmentStrategyType;
import ParkingLot.models.ParkingLot;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentStrategyByType(SlotAssignmentStrategyType slotAssignmentStrategyType){
        return new RandomSlotAssignmentStrategy();
    }
}
