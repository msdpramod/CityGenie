package org.commerceproject.ecommerceprodcutservice.Exceptions;

import org.commerceproject.ecommerceprodcutservice.DTOs.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(NotFoundException.class)
    //
    public ResponseEntity<ExceptionDTO> handleException(NotFoundException e) {
        return new ResponseEntity<>(
                new ExceptionDTO(  HttpStatus.NOT_FOUND, e.getMessage()) , HttpStatus.NOT_FOUND);
    }
}
