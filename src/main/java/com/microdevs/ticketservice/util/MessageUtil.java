package com.microdevs.ticketservice.util;

import lombok.experimental.UtilityClass;

    @UtilityClass
    public class MessageUtil {
        public static final String EVENT_NOT_FOUND_WITH_ID = "No event record found for id number %s";

        public static final String USER_NOT_FOUND_WITH_ID = "No user record found for id number %s";

        public static String getMessageDetail(String message, Object argument) {
            return String.format(message, argument.toString());
        }

        public static String getMessageDetail(String message) {
            return String.format(message);
        }
    }

