package com.microdevs.ticketservice.client.service;

import com.microdevs.ticketservice.client.dto.EventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="event", url = "http://localhost:9001")
public interface EventServiceClient {
    @GetMapping("/getAllEvents")
    List<EventDto> getAllEvents();

}
