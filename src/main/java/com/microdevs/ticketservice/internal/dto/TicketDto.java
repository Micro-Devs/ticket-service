package com.microdevs.ticketservice.internal.dto;

import com.microdevs.baseservice.enums.StatusType;
import lombok.*;


import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TicketDto {
    private UUID id;
    private String billingNo;
    private BigDecimal price;
    private StatusType status;
}
