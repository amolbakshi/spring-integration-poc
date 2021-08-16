package com.amol.poc.integration.service;

import com.amol.poc.integration.model.ExceptionLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    
    @ServiceActivator(inputChannel = "exceptionLogger")
    public void exceptionLogger(Message<ExceptionLogger> message) {
        logger.info("exception recieved");
        logger.info(message.getPayload().toString());
    }
    
}
