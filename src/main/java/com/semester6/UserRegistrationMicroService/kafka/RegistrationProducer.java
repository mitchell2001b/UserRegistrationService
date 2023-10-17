package com.semester6.UserRegistrationMicroService.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semester6.UserRegistrationMicroService.Account.Account;
import com.semester6.UserRegistrationMicroService.Events.UserCreatedEvent;
import com.semester6.UserRegistrationMicroService.dtos.AccountDto;
import org.apache.catalina.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationProducer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;
    private ObjectMapper ObjectMapperJson;

    public RegistrationProducer(NewTopic topic, KafkaTemplate<String, UserCreatedEvent> kafkaTemplate, ObjectMapper objectMapper)
    {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
        this.ObjectMapperJson = objectMapper;
    }

    public void SendMessage(Object accountEvent)
    {
        try {
            String jsonPayload = ObjectMapperJson.writeValueAsString(accountEvent);

            LOGGER.info(String.format("Registration event => %s", jsonPayload));

            Message<String> message = MessageBuilder
                    .withPayload(jsonPayload)
                    .setHeader(KafkaHeaders.TOPIC, topic.name())
                    .build();
            kafkaTemplate.send(message);

        } catch (JsonProcessingException e) {

            LOGGER.error("Error serializing payload to JSON", e);
        }
    }
}
