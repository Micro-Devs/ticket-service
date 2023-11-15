package com.microdevs.ticketservice.client.service;

import com.microdevs.ticketservice.client.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user", url = "http://localhost:9004")
public interface UserServiceClient {

    @GetMapping("/getAllUsers")
    List<UserDto> getAllUsers();
}
