package com.microdevs.ticketservice.producer.mapper;

import com.microdevs.ticketservice.producer.dto.EventDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public abstract class ProducerMapper {
    ProducerMapper INSTANCE = Mappers.getMapper(ProducerMapper.class);

    public EventDetailDto toProducer(Long eventId, Long userId, UUID id) {
        EventDetailDto producerDTO = new EventDetailDto();
        producerDTO.setUuid(id);
        producerDTO.setEventId(eventId);
        producerDTO.setUserId(userId);

        return producerDTO;
    }
}
