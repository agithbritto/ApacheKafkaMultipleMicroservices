package com.example.OrderService.KafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Configuration
public class KafkaConfiguration {

	@Value("${spring.kafka.topic.name}")
    private String topicName;
	
	@Bean
	public NewTopic createKafkaTopic() {
		return TopicBuilder.name(topicName)
                .build();
	}
}
