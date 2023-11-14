package com.microdevs.ticketservice.web.controller;

import com.microdevs.ticketservice.internal.dto.TicketDto;
import com.microdevs.ticketservice.internal.service.TicketService;
import com.microdevs.ticketservice.web.controller.dto.CreateTicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody CreateTicket createTicket){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.createTicket(createTicket));
    }
}
