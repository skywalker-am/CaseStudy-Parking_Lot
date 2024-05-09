package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.repositories.ParkingLotRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotrepository) {
        this.parkingLotRepository = parkingLotrepository;
    }

    public ParkingLot insertParkingLot(
            int capacity,
            ParkingLotStatus parkingLotStatus,
            List<VehicleType> vehicleTypeList,
            SlotAssignmentStrategyType slotAssignmentStrategyType
    )
    {
        ParkingLot parkingLot = new ParkingLot();

        parkingLot.setCapacity(capacity);
        parkingLot.setParkingLotStatus(parkingLotStatus);
        parkingLot.setVehicleTypes(vehicleTypeList);
        parkingLot.setSlotAssignmentStrategyType(slotAssignmentStrategyType);
        parkingLot.setCreatedAt(new Date());
        parkingLot.setModifiedAt(new Date());

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.save(parkingLot);

        if(parkingLotOptional.isEmpty()){
            throw new RuntimeException("Failed to insert parking lot");
        }

        return parkingLotOptional.get();
    }

    public List<ParkingLot> getParkingLots() {
        Optional<List<ParkingLot>> parkingLotsOptional =   parkingLotRepository.getAll();

        if (parkingLotsOptional.isEmpty()) {
            throw new RuntimeException("No parking lots found");
        }

        return parkingLotsOptional.get();
    }
}
