package com.microdevs.ticketservice.producer.service;

import com.microdevs.ticketservice.producer.dto.EventDetailDto;
import com.microdevs.ticketservice.properties.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketProducerService {
    private final KafkaTemplate<String, EventDetailDto> kafkaTemplate;
    private final KafkaProperties properties;

    public TicketProducerService(KafkaTemplate<String, EventDetailDto> kafkaTemplate, KafkaProperties properties) {
        this.kafkaTemplate = kafkaTemplate;
        this.properties = properties;
    }

    public void produce(EventDetailDto message) {
        kafkaTemplate.send(properties.getTopicName(), message);
    }
}
