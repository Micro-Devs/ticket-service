package com.microdevs.ticketservice.data.service;

import com.microdevs.ticketservice.data.entity.Ticket;
import com.microdevs.ticketservice.data.mapper.TicketMapper;
import com.microdevs.ticketservice.data.repository.TicketRepository;
import com.microdevs.ticketservice.internal.dto.TicketDto;
import com.microdevs.ticketservice.web.controller.dto.CreateTicket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketDataService {
    private final TicketRepository repository;
    private final TicketMapper mapper;


    public TicketDataService(TicketRepository repository, TicketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TicketDto create(BigDecimal price, String billingNo){
       Ticket createdEntity = repository.save(mapper.toEntity(price,billingNo));
       return mapper.toDto(createdEntity);
    }
}
