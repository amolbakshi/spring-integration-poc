package com.amol.poc.integration.gateways;

import com.amol.poc.integration.model.InputMessage;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface InputGateway {
    @Gateway(requestChannel = "inputChannel")
    public void processInputMessage(Message<InputMessage> message);    
}
