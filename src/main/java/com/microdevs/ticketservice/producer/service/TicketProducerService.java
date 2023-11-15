package com.microdevs.ticketservice.producer.service;

import com.microdevs.ticketservice.producer.dto.EventDetailDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketProducerService {
    private final KafkaTemplate<String, EventDetailDto> kafkaTemplate;
    private final String TOPIC_NAME = "ticket-activity";

    public TicketProducerService(KafkaTemplate<String, EventDetailDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(EventDetailDto message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
