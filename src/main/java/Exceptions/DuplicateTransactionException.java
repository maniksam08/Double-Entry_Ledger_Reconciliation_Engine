package Exceptions;

public class DuplicateTransactionException extends RuntimeException{
    private String referenceId;

    public DuplicateTransactionException(String referenceId){
        super(String.format("Transaction request for referenceId: %s already exists", referenceId));
        this.referenceId= referenceId;
    }
}
