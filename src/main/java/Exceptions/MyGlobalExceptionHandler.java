package Exceptions;

import dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class MyGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> response = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String message = err.getDefaultMessage();
            response.put(fieldName, message);
        });
        log.warn("Validation failed: fields={}", response.keySet());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<ApiResponse> ResNotFound(AccountNotFound e) {
        log.warn("Account not found: {}", e.getMessage());
        String Message = e.getMessage();
        ApiResponse res = new ApiResponse(Message, false);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIexception.class)
    public ResponseEntity<ApiResponse> myapiexcep(APIexception e) {
        log.warn("API exception: {}", e.getMessage());
        String Message = e.getMessage();
        ApiResponse res = new ApiResponse(Message, false);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateTransactionException.class)
    public ResponseEntity<ApiResponse> duplicTransac(DuplicateTransactionException e) {
        log.warn("Duplicate transaction: {}", e.getMessage());
        String Message = e.getMessage();
        ApiResponse res = new ApiResponse(Message, false);
        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ApiResponse> insufFunda(InsufficientFundsException e) {
        log.warn("Insufficient funds: {}", e.getMessage());
        String Message = e.getMessage();
        ApiResponse res = new ApiResponse(Message, false);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
