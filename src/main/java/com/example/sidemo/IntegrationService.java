package com.example.sidemo;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class IntegrationService {
    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void anotherMessage(Message<String> message ) {
        System.out.println(new Date() + " onMessage");
        MessageChannel replyChannel = (MessageChannel)message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        Message<String> newMessage = MessageBuilder.withPayload("Welcome, " + message.getPayload() + " to Spring Integration").build();
        replyChannel.send(newMessage);
    }
}
