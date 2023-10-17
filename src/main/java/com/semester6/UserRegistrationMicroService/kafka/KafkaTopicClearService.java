package com.semester6.UserRegistrationMicroService.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicClearService
{
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaTopicClearService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void clearTopic(String topicName) {
        kafkaTemplate.send(topicName, null);
    }
}
