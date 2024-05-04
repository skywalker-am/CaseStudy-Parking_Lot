package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TokenRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TokenService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TokenRepository tokenRepository;

    public TokenService(
            GateRepository gateRepository,
            VehicleRepository vehicleRepository,
            ParkingLotRepository parkingLotRepository,
            TokenRepository tokenRepository
    ) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepository = tokenRepository;
    }

    public Token issueToken(Long gateId, String vehicleNumber, VehicleType vehicleType, String ownerName){

        // 1. create a Token
        Token token = new Token();

        //set Entry Time
        token.setEntryTime(new Date());

        // using the gateId, we need the gate object from the database
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);

        if(optionalGate.isEmpty()){
            throw new RuntimeException("Invalid gate is entered!");
        }

        Gate gate = optionalGate.get();

        //set Gate and Operator
        token.setGeneratedAt(gate);
        token.setGeneratedBy(gate.getOperator());

        // check if the vehicle already exists
        Optional<Vehicle> vehicleOptional =  vehicleRepository.findVehicleByNumber(vehicleNumber);

        Vehicle savedVehicle;

        if (vehicleOptional.isPresent()) {
            // if the vehicle already exists
            savedVehicle = vehicleOptional.get();
        } else {
            // Since this is the new vehicle
            // let's create the obj and save it in the db
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);

            savedVehicle = vehicleRepository.save(vehicle);
        }

        token.setVehicle(savedVehicle);

        // 2. Assign a Slot
                // we can have different strategies to allocate the slot

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findParkingLotByGate(gate);


        if(parkingLotOptional.isEmpty()){
            throw new RuntimeException("Invalid parking gate is entered!");
        }

        ParkingLot parkingLot = parkingLotOptional.get();

        Optional<ParkingSlot> parkingSlotOptional = SlotAssignmentStrategyFactory
                .getSlotAssignmentStrategyByType(parkingLot.getSlotAssignmentStrategyType())
                .getSlot(parkingLot, vehicleType);

        if (parkingSlotOptional.isEmpty()){
            throw new RuntimeException("Parking Slot not available!");
        }

        ParkingSlot parkingSlot = parkingSlotOptional.get();

        parkingSlot.setSlotStatus(SlotStatus.FILLED);
        token.setAssignedSlot(parkingSlot);

        Token savedToken = tokenRepository.save(token);
        savedToken.setNumber(savedToken.getId() + "-TOKEN");

        //3. return
        return tokenRepository.update(savedToken);
    }
}
