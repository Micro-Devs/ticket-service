package com.microdevs.ticketservice.data.service;

import com.microdevs.ticketservice.data.entity.Ticket;
import com.microdevs.ticketservice.data.repository.TicketRepository;
import com.microdevs.ticketservice.internal.dto.TicketDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketDataService {
    private final TicketRepository repository;





    public TicketDataService(TicketRepository repository ) {
        this.repository = repository;
    }

    public TicketDto create(BigDecimal price, String billingNo){
        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setBillingNo(billingNo);

       Ticket createdEntity = repository.save(ticket);

       TicketDto ticketDto  = TicketDto.builder()
               .status(createdEntity.getStatus())
               .price(createdEntity.getPrice())
               .billingNo(createdEntity.getBillingNo())
               .id(createdEntity.getGuid()).build();

       return ticketDto;
    }
}
