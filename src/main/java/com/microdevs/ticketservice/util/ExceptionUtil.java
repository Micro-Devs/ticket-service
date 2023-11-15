package com.microdevs.ticketservice.util;

import lombok.Getter;

@Getter
public enum ExceptionUtil {

    EVENT_NOT_FOUND(500, "Event not found"),
    USER_NOT_FOUND(501, "User not found");

    private final int code;
    private final String message;

    ExceptionUtil(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
