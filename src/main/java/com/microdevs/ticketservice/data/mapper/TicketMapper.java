package com.microdevs.ticketservice.data.mapper;

import com.microdevs.ticketservice.data.entity.Ticket;
import com.microdevs.ticketservice.internal.dto.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper
public abstract class TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);


   public Ticket toEntity(BigDecimal price, String billingNo){
        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setBillingNo(billingNo);
        return ticket;
    }

    public abstract TicketDto toDto(Ticket createdEntity);


}
