package com.microdevs.ticketservice.exception;

import com.microdevs.baseservice.exception.MicroException;

public class EventNotFoundException extends MicroException{
    public EventNotFoundException(String message, Integer errorCode, String messageDetail) {
        super(message, errorCode, messageDetail);
    }
}


