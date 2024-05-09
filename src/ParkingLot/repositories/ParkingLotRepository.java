package ParkingLot.repositories;

import ParkingLot.models.Gate;
import ParkingLot.models.Operator;
import ParkingLot.models.ParkingLot;

import java.util.*;

public class ParkingLotRepository {
    private Map<Long,ParkingLot> parkingLots = new TreeMap<>();
    private Long id = 0L;

    public Optional<ParkingLot> findParkingLotByGate(Gate gate) {
        for(ParkingLot parkingLot : parkingLots.values()){
            if(parkingLot.getGates().contains(gate)){
                return Optional.of(parkingLot);
            }
        }

        return Optional.empty();
    }

    public Optional<ParkingLot> save(ParkingLot parkingLot) {
        id +=  1;

        parkingLot.setId(id);
        parkingLots.put(id, parkingLot);

        if(parkingLots.containsKey(id)){
            return Optional.of(parkingLots.get(id));
        }

        return Optional.empty();
    }

    public Optional<List<ParkingLot>> getAll() {
        if(!parkingLots.isEmpty()){
            return Optional.of(new ArrayList<>(parkingLots.values()));

        }

        return Optional.empty();

    }
}
