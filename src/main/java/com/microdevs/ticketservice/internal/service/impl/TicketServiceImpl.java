package com.microdevs.ticketservice.internal.service.impl;

import com.microdevs.ticketservice.client.dto.EventDto;
import com.microdevs.ticketservice.client.service.EventServiceClient;
import com.microdevs.ticketservice.data.service.TicketDataService;
import com.microdevs.ticketservice.exception.UserNotFoundException;
import com.microdevs.ticketservice.internal.dto.TicketDto;
import com.microdevs.ticketservice.internal.service.TicketService;
import com.microdevs.ticketservice.util.ExceptionUtil;
import com.microdevs.ticketservice.util.MessageUtil;
import com.microdevs.ticketservice.web.controller.dto.CreateTicket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    private final EventServiceClient eventServiceClient;
    private final TicketDataService dataService;

    public TicketServiceImpl(EventServiceClient eventServiceClient, TicketDataService dataService) {
        this.eventServiceClient = eventServiceClient;
        this.dataService = dataService;
    }

    @Override
    public TicketDto createTicket(CreateTicket createTicket) {
        isUserValid(createTicket.getUserId());
        return dataService.create(isEventValidAndGetPrice(createTicket.getEventId())
                ,billingNoGenerator());
    }

    private BigDecimal isEventValidAndGetPrice(Long eventId){
        Optional<BigDecimal> price = eventServiceClient.getAllEvents().stream()
                .filter(event -> eventId.equals(event.getId()))
                .findAny()
                .map(EventDto::getPrice);

        return price.orElseThrow(() ->
                 new UserNotFoundException(ExceptionUtil.EVENT_NOT_FOUND.getMessage()
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

    private  String billingNoGenerator(){
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        return UUID.randomUUID()+Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }


}
