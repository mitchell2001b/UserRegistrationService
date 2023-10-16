package com.semester6.UserRegistrationMicroService.kafka;

import com.semester6.UserRegistrationMicroService.Account.Account;
import com.semester6.UserRegistrationMicroService.dtos.AccountDto;
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
    private KafkaTemplate<String, AccountDto> kafkaTemplate;

    public RegistrationProducer(NewTopic topic, KafkaTemplate<String, AccountDto> kafkaTemplate)
    {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void SendMessage(AccountDto accountEvent)
    {
        LOGGER.info(String.format("Registration event => %s", accountEvent.toString()));

        //create message

        Message<AccountDto> message = MessageBuilder
                .withPayload(accountEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
