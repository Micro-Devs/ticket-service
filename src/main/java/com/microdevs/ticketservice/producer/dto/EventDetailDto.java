package com.microdevs.ticketservice.producer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EventDetailDto {
    private UUID uuid;
    private Long eventId;
    private Long userId;

}
