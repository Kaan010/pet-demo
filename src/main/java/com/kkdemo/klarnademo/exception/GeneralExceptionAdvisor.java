package com.kkdemo.klarnademo.exception;

import com.kkdemo.klarnademo.model.dto.RequestDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoKlarnautFoundException.class)
    public ResponseEntity<?> handle(NoKlarnautFoundException exception) {
        return handleNotCRUD(exception.getMessage());
    }

    @ExceptionHandler(RequestCoulndtCreatedException.class)
    public ResponseEntity<?> handle(RequestCoulndtCreatedException exception) {
        return handleNotCRUD(exception.getMessage());
    }

    private ResponseEntity<?> handleCreateRequestD(String s) {
        return new ResponseEntity<>(s, HttpStatus.I_AM_A_TEAPOT);
    }

    private ResponseEntity<?> handleNotCRUD(String s) {
        return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
    }
}
