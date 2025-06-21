package com.sk.spring_boot_day2_restAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotesNotFoundException.class)
    public ResponseEntity<ExceptionBody> handleNotesNotFoundException( NotesNotFoundException exception){
        ExceptionBody exe= new ExceptionBody();
        exe.setMessage(exception.getMessage());
        exe.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exe, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionBody> handleMethodArgumentNotValidException( MethodArgumentNotValidException exception){
        ExceptionBody exe= new ExceptionBody();
        exe.setTimestamp(LocalDateTime.now());

        List<String> error= exception.getBindingResult().getFieldErrors().stream().map(errordef ->errordef.getField() +" : "+errordef.getDefaultMessage()).collect(Collectors.toList());
        exe.setMessage(error.get(0));
        return new ResponseEntity<>(exe, HttpStatus.NOT_FOUND);

    }
}
