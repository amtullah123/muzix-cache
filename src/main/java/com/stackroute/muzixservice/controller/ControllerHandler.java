package com.stackroute.muzixservice.controller;

import com.stackroute.muzixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler(value= TrackAlreadyExistsException.class)
    public ResponseEntity<String> globalException(TrackAlreadyExistsException exception)
    {
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        return responseEntity;
    }
    @ExceptionHandler(value= TrackNotFoundException.class)
    public ResponseEntity<String> globalException1(TrackNotFoundException exception1)
    {
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        return responseEntity;
    }
}