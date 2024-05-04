package ParkingLot.controllers;

import ParkingLot.dtos.IssueTokenRequestDTO;
import ParkingLot.models.Token;
import ParkingLot.services.TokenService;

public class TokenController {
    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public void issueToken(IssueTokenRequestDTO issueTokenRequestDTO){

         Token token = tokenService.issueToken(
                 issueTokenRequestDTO.getGateId(),
                 issueTokenRequestDTO.getVehicleNumber(),
                 issueTokenRequestDTO.getVehicleType(),
                 issueTokenRequestDTO.getOwnerName()
         );

    }
}


// For every use case

    //UseCase 1:
        // IssueToken()
            // Major model : CRUD : Token Model
            // TokenController
            // Name the controller on the model



