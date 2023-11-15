package com.microdevs.ticketservice.internal.service;

import com.microdevs.ticketservice.internal.dto.TicketDto;
import com.microdevs.ticketservice.web.controller.dto.CreateTicket;

public interface TicketService {
    TicketDto createTicket(CreateTicket createTicket);
}
