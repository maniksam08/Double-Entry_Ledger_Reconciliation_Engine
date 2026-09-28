package Exceptions;

import java.util.UUID;

public class InsufficientFundsException extends RuntimeException {
    private UUID uuid;

    public InsufficientFundsException(UUID uuid){
        super(String.format("Insufficient funds for account id: %s", uuid));
        this.uuid= uuid;
    }
}
