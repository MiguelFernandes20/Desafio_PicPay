package com.example.desafio_picpay.config;

import com.example.desafio_picpay.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.datatype.DatatypeConfigurationException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DatatypeConfigurationException.class)
    public ResponseEntity threatDuplicateEntry(DatatypeConfigurationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuario ja cadastrado.", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(EntityNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}