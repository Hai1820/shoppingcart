package com.myclass.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameAlreadyExist(UsernameAlreadyExistsException ex, WebRequest request){
        UsernameAlreadyExistResponse usernameAlreadyExistResponse = new UsernameAlreadyExistResponse(ex.getMessage());
        return new ResponseEntity<>(usernameAlreadyExistResponse, HttpStatus.BAD_REQUEST);
    }
}
