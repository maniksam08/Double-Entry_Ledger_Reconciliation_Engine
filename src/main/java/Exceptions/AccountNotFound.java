package Exceptions;

import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class AccountNotFound extends RuntimeException{
    UUID uuid;

    public AccountNotFound(UUID uuid){
        super(String.format("Account not found %s", uuid));
        this.uuid= uuid;
    }
}
