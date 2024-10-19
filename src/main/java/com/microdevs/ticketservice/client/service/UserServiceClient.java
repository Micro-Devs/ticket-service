package com.microdevs.ticketservice.client.service;

import com.microdevs.ticketservice.client.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${feign.client.user.name}", url = "${feign.client.user.url}")
public interface UserServiceClient {

    @GetMapping("${feign.client.user.path}")
    List<UserDto> getAllUsers();
}
