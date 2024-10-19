package com.microdevs.ticketservice.client.service;

import com.microdevs.ticketservice.client.dto.EventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${feign.client.event.name}", url = "${feign.client.event.url}")
public interface EventServiceClient {
    @GetMapping("${feign.client.event.path}")
    List<EventDto> getAllEvents();
}