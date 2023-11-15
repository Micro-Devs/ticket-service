package com.microdevs.ticketservice.client.dto;

import com.microdevs.baseservice.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private StatusType status;
}
