package ParkingLot.controllers;

import ParkingLot.dtos.IssueTokenRequestDTO;
import ParkingLot.dtos.IssueTokenResponseDTO;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.models.Token;
import ParkingLot.services.TokenService;

public class TokenController {
    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public IssueTokenResponseDTO issueToken(IssueTokenRequestDTO issueTokenRequestDTO){

        IssueTokenResponseDTO response = new IssueTokenResponseDTO();

        try {
            Token token = tokenService.issueToken(
                    issueTokenRequestDTO.getGateId(),
                    issueTokenRequestDTO.getVehicleNumber(),
                    issueTokenRequestDTO.getVehicleType(),
                    issueTokenRequestDTO.getOwnerName()
            );

            response.setToken(token);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            return response;
        }catch (Exception exception){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(exception.getMessage());
            return response;
        }


    }
}


// For every use case

    //UseCase 1:
        // IssueToken()
            // Major model : CRUD : Token Model
            // TokenController
            // Name the controller on the model



