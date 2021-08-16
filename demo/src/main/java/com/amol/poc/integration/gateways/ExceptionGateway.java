package com.amol.poc.integration.gateways;

import com.amol.poc.integration.model.ExceptionLogger;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface ExceptionGateway {
    @Gateway(requestChannel = "exceptionLogger")
    public void logException(Message<ExceptionLogger> message);
}
