package ParkingLot.facades;

public class ParkingLotFacade {

    public void creatingParkingLot(){

        //*************************Creating Parking Lots record in MAP TABLE***************************
        /*
        ParkingLotRepository parkingLotrepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotrepository);
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);

        InsertParkingLotRequestDTO insertParkingLotRequestDTO = new InsertParkingLotRequestDTO();

        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot =  new ParkingLot();
        parkingLot.setCapacity(1000);
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setVehicleTypes(new ArrayList<VehicleType>(Arrays.asList(VehicleType.BICYCLE, VehicleType.TRUCK, VehicleType.CAR ,VehicleType.BIKE)));
        parkingLot.setSlotAssignmentStrategyType(SlotAssignmentStrategyType.RANDOM);
        parkingLots.add(parkingLot);

        ParkingLot parkingLot2 =  new ParkingLot();
        parkingLot2.setCapacity(2000);
        parkingLot2.setParkingLotStatus(ParkingLotStatus.FILLED);
        parkingLot2.setVehicleTypes(new ArrayList<VehicleType>(Arrays.asList(VehicleType.CAR, VehicleType.BIKE)));
        parkingLot2.setSlotAssignmentStrategyType(SlotAssignmentStrategyType.RANDOM);
        parkingLots.add(parkingLot2);

        for(ParkingLot parkingLotLoop : parkingLots){
            insertParkingLotRequestDTO.setCapacity(parkingLotLoop.getCapacity());
            insertParkingLotRequestDTO.setParkingLotStatus(parkingLotLoop.getParkingLotStatus());
            insertParkingLotRequestDTO.setVehicleTypeList(parkingLotLoop.getVehicleTypes());
            insertParkingLotRequestDTO.setSlotAssignmentStrategyType(parkingLotLoop.getSlotAssignmentStrategyType());


            InsertParkingLotResponseDTO insertParkingLotResponseDTO  = parkingLotController.insertParkingLot(insertParkingLotRequestDTO);


            if(insertParkingLotResponseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)) {
                System.out.println("Failure Message : " + insertParkingLotResponseDTO.getFailureMessage());
                return;
            }
        }

        System.out.println("Parking Lots are inserted successfully!");

        //*************************End Creating Parking Lots in MAP TABLE******************************
    }


    public void gettingParkingLot(){
        //*******************************Fetching PARKING LOT records from MAP TABLE*********************

        GetParkingLotResponseDTO getParkingLotResponseDTO = parkingLotController.getParkingLot();

        if (getParkingLotResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            List<ParkingLot> getSavedParkingLots = getParkingLotResponseDTO.getParkingLots();
            for (ParkingLot parkingLotResponse : getSavedParkingLots) {
                System.out.println("List of Floors : " + parkingLotResponse.getParkingFloors());
                System.out.println("List of Gates : " + parkingLotResponse.getGates());
                System.out.println("Capacity : " + parkingLotResponse.getCapacity());
                System.out.println("Status: " + parkingLotResponse.getParkingLotStatus());
                System.out.println("Allowed Vehicle Types: " + parkingLotResponse.getVehicleTypes());
                System.out.println("Slot Assignment Strategy Type: " + parkingLotResponse.getSlotAssignmentStrategyType());

                System.out.println("Operator Created At : " + parkingLotResponse.getCreatedAt());
                System.out.println("Operator Modified At : " + parkingLotResponse.getModifiedAt());
                System.out.println("--------------------------------------");


                //System.out.println("parkingLotResponse");
            }
        } else {
            System.out.println("Failure Message : " + getParkingLotResponseDTO.getFailureMessage());
        }

        //************************** End Fetching PARKING LOT records from MAP TABLE**************************

        */

    }


}
