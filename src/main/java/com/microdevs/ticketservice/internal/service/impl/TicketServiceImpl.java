package com.microdevs.ticketservice.internal.service.impl;

import com.microdevs.ticketservice.client.dto.EventDto;
import com.microdevs.ticketservice.client.service.EventServiceClient;
import com.microdevs.ticketservice.data.service.TicketDataService;
import com.microdevs.ticketservice.exception.EventNotFoundException;
import com.microdevs.ticketservice.exception.UserNotFoundException;
import com.microdevs.ticketservice.internal.dto.TicketDto;
import com.microdevs.ticketservice.internal.service.TicketService;
import com.microdevs.ticketservice.producer.mapper.ProducerMapper;
import com.microdevs.ticketservice.producer.service.TicketProducerService;
import com.microdevs.ticketservice.util.ExceptionUtil;
import com.microdevs.ticketservice.util.MessageUtil;
import com.microdevs.ticketservice.web.controller.dto.CreateTicket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    private final EventServiceClient eventServiceClient;
    private final TicketDataService dataService;
    private final TicketProducerService producerService;
    private final ProducerMapper producerMapper;

    public TicketServiceImpl(EventServiceClient eventServiceClient, TicketDataService dataService, TicketProducerService producerService, ProducerMapper producerMapper) {
        this.eventServiceClient = eventServiceClient;
        this.dataService = dataService;
        this.producerService = producerService;
        this.producerMapper = producerMapper;
    }

    @Override
    public TicketDto createTicket(CreateTicket createTicket) {
        isUserValid(createTicket.getUserId());
        TicketDto createdTicket=  dataService.create(isEventValidAndGetPrice(createTicket.getEventId())
                ,billingNoGenerator());

        producerService.produce(producerMapper.toProducer(createTicket.getEventId(),createTicket.getUserId()
                ,createdTicket.getId()));

        return createdTicket;

    }

    private BigDecimal isEventValidAndGetPrice(Long eventId){
        Optional<BigDecimal> price = eventServiceClient.getAllEvents().stream()
                .filter(event -> eventId.equals(event.getId()))
                .findAny()
                .map(EventDto::getPrice);

        return price.orElseThrow(() ->
                 new EventNotFoundException(ExceptionUtil.EVENT_NOT_FOUND.getMessage()
                        , ExceptionUtil.EVENT_NOT_FOUND.getCode()
                        ,MessageUtil.getMessageDetail(MessageUtil.EVENT_NOT_FOUND_WITH_ID, eventId))
        );
    }


    private void isUserValid(Long userId){
        boolean isValid = eventServiceClient.getAllEvents().stream()
                .anyMatch(event -> userId.equals(event.getId()));

        if(!isValid)
            throw new UserNotFoundException(ExceptionUtil.USER_NOT_FOUND.getMessage()
                    , ExceptionUtil.USER_NOT_FOUND.getCode()
                    ,MessageUtil.getMessageDetail(MessageUtil.USER_NOT_FOUND_WITH_ID, userId));
    }

    private String billingNoGenerator(){
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        return UUID.randomUUID()+Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }


}
