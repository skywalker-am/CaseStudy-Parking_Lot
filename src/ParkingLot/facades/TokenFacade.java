package ParkingLot.facades;

public class TokenFacade {
    public void creatingToken(){
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
    }
}
