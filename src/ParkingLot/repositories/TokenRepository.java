package ParkingLot.repositories;

import ParkingLot.models.Token;

import java.util.Map;
import java.util.TreeMap;

public class TokenRepository {
    private Map<Long , Token> tokens = new TreeMap<>();
    private Long id = 0L;

    public Token save(Token token) {
        id += 1;
        token.setId(id);
        tokens.put(id, token);
        return token;
    }

    public Token update(Token savedToken) {
        tokens.put(savedToken.getId(), savedToken);
        return tokens.get(savedToken.getId());

    }
}
