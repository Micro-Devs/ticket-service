package com.microdevs.ticketservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic ticketActivity() {
        return new NewTopic("ticket-activity", 3, Short.parseShort("2"));
    }

}
