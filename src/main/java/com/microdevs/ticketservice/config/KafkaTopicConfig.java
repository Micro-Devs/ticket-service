package com.microdevs.ticketservice.config;

import com.microdevs.ticketservice.properties.KafkaProperties;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    private final KafkaProperties properties;

    public KafkaTopicConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public NewTopic ticketActivity() {
        return new NewTopic(properties.getTopicName(), properties.getTopicPartition(), Short.parseShort(properties.getBroker()));
    }

}
