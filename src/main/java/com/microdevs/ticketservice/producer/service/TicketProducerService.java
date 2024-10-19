package com.microdevs.ticketservice.producer.service;

import com.microdevs.ticketservice.producer.dto.EventDetailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketProducerService {
    private final KafkaTemplate<String, EventDetailDto> kafkaTemplate;


    public TicketProducerService(KafkaTemplate<String, EventDetailDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(EventDetailDto message) {
        kafkaTemplate.send("ticket-activity",message);
    }
}
