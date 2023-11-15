package com.microdevs.ticketservice.config;

import com.microdevs.ticketservice.data.mapper.TicketMapper;
import com.microdevs.ticketservice.producer.mapper.ProducerMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {
    @Bean
    public TicketMapper userMapper() {
        return Mappers.getMapper(TicketMapper.class);
    }
    @Bean
    public ProducerMapper producerMapper() {
        return Mappers.getMapper(ProducerMapper.class);
    }
}