package com.amol.poc.integration.service;

import java.util.Date;

import javax.annotation.Resource;

import com.amol.poc.integration.gateways.AuditGateway;
import com.amol.poc.integration.gateways.ExceptionGateway;
import com.amol.poc.integration.model.Audit;
import com.amol.poc.integration.model.ExceptionLogger;
import com.amol.poc.integration.model.InputMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InputService {
    
    private static final Logger logger = LoggerFactory.getLogger(InputService.class);


    @Autowired
    private AuditGateway auditChannel;

    @Autowired
    private ExceptionGateway exceptionChannel;
    
    
    @ServiceActivator(inputChannel = "inputChannel")
    public void processInputMessage(Message<InputMessage> message) {
        logger.info("message recieved");
        InputMessage inputMessage = message.getPayload();
        logger.info(inputMessage.toString());

        Audit audit = new Audit("001","test aud",new Date());
        Message<Audit> auditMessage = MessageBuilder.withPayload(audit).build();
        auditChannel.logAudit(auditMessage);

        ExceptionLogger exceptionLogger = new ExceptionLogger("500","Error Occured");
        Message<ExceptionLogger> exceptionLoggerMessage = MessageBuilder.withPayload(exceptionLogger).build();
        exceptionChannel.logException(exceptionLoggerMessage);
    }

}
