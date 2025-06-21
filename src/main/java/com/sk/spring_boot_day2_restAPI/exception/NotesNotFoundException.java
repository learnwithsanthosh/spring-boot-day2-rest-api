package com.sk.spring_boot_day2_restAPI.exception;

public class NotesNotFoundException extends RuntimeException{

    public NotesNotFoundException(String message){
        super(message);
    }
}
