package com.microdevs.ticketservice.data.entity;

import com.microdevs.baseservice.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ticket", schema = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(generator = "ticket_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ticket_sequence", sequenceName = "ticket_sequence", allocationSize = 1)
    private UUID id;
    private String billingNo;
    private BigDecimal price;
    @NotNull
    private StatusType status = StatusType.ACTIVE;
}
