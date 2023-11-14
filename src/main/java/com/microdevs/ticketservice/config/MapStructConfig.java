package com.microdevs.ticketservice.config;

import com.microdevs.ticketservice.data.mapper.TicketMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {
    @Bean
    public TicketMapper userMapper() {
        return Mappers.getMapper(TicketMapper.class);
    }

}