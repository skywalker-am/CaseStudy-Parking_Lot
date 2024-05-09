package ParkingLot.extras;

public class ExtraClient {
    public void extra(){

         /*
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();
        TokenRepository tokenRepository = new TokenRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();


        TokenService tokenService = new TokenService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                tokenRepository
        );

        TokenController tokenController = new TokenController(tokenService);

        IssueTokenRequestDTO issueTokenRequestDTO = new IssueTokenRequestDTO();
        issueTokenRequestDTO.setVehicleNumber("UP 70 0001");
        issueTokenRequestDTO.setGateId(1L);
        issueTokenRequestDTO.setVehicleType(VehicleType.CAR);
        issueTokenRequestDTO.setOwnerName("Abhishek Mishra");


       IssueTokenResponseDTO issueTokenResponseDTO = tokenController.issueToken(issueTokenRequestDTO);


        if(issueTokenResponseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println("Failure Message : " + issueTokenResponseDTO.getFailureMessage());
        }else {
            System.out.println("Entry Time : " + issueTokenResponseDTO.getToken().getEntryTime());
            System.out.println("Token No. : " + issueTokenResponseDTO.getToken().getNumber());
            System.out.println("Gate No. : " + issueTokenResponseDTO.getToken().getGeneratedAt());
            System.out.println("Vehicle Type : " + issueTokenResponseDTO.getToken().getVehicle().getVehicleType());
            System.out.println("Owner Name : " + issueTokenResponseDTO.getToken().getVehicle().getOwnerName());
            System.out.println("Vehicle No. : " + issueTokenResponseDTO.getToken().getVehicle().getNumber());
        }
        */



        //...............................PARKING LOT operations .......................................

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
         */
        //*************************End Creating Parking Lots in MAP TABLE******************************

        //*******************************Fetching PARKING LOT records from MAP TABLE*********************
        /*
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

         */

        //************************** End Fetching PARKING LOT records from MAP TABLE**************************


        //...............................End PARKING LOT operations ....................................



        //................................  OPERATOR operations.........................................

        //*****************************Creating Operators record in MAP TABLE***************************
        /*
        OperatorRepository operatorRepository = new OperatorRepository();
        OperatorService operatorService = new OperatorService(operatorRepository);
        OperatorController operatorController = new OperatorController(operatorService);

        InsertOperatorRequestDTO insertOperatorRequestDTO = new InsertOperatorRequestDTO();

        List<String> operators = new ArrayList<>();
        operators.add("Ramesh");
        operators.add("Vinod");
        operators.add("Rakesh");
        operators.add("Sanjay");

        for(String operator : operators){
            insertOperatorRequestDTO.setOperatorName(operator);
            InsertOperatorResponseDTO insertOperatorResponseDTO  = operatorController.insertOperator(insertOperatorRequestDTO);

            if(insertOperatorResponseDTO.getResponseStatus().equals(ResponseStatus.FAILURE) ) {
                System.out.println("Failure Message : " + insertOperatorResponseDTO.getFailureMessage()
                        +'"'+insertOperatorResponseDTO.getOperator().getName()+'"');
                return;
            }
        }

        System.out.println("Operators are inserted successfully!");
        //******************************End Creating Operators record in MAP TABLE********************

        //*******************************Fetching Operators record from MAP TABLE*********************
        GetOperatorResponseDTO getOperatorResponseDTO  = operatorController.getOperators();
        if (getOperatorResponseDTO.getResponseStatus()) {
            List<Operator> getSavedOperators = getOperatorResponseDTO.getOperators();
            for (Operator operator : getSavedOperators) {
                System.out.println("Operator Name : " + operator.getName());
                System.out.println("Operator Emp ID : " + operator.getEmpId());
                System.out.println("Operator Created At : " + operator.getCreatedAt());
                System.out.println("Operator Modified At : " + operator.getModifiedAt());
                System.out.println("--------------------------------------");
            }
        } else {
            System.out.println("Failure Message : " + getOperatorResponseDTO.getFailureMessage());
        }

         */
        //********************************End Fetching Operators record from MAP TABLE**************************

        //.......................................End OPERATOR operations........................................
    }
}
