package com.microdevs.ticketservice.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTicket {
    @NotNull
    private Long userId;
    @NotNull
    private Long eventId;
}
