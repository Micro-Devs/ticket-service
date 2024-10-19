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
    @Column(name = "guid", nullable = false)
    private UUID guid = UUID.randomUUID();
    @Column(name = "billingNo", nullable = false)
    private String billingNo;
    @Column(name = "price", nullable = false, precision = 7, scale = 2)
    private BigDecimal price;
    @Column(name = "status", nullable = false)
    private StatusType status = StatusType.ACTIVE;
}

