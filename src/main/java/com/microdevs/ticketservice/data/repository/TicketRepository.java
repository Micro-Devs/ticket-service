package com.microdevs.ticketservice.data.repository;

import com.microdevs.ticketservice.data.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket,UUID> {
}
