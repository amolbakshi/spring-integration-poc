package com.amol.poc.integration.service;

import com.amol.poc.integration.model.Audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditService {
    private static final Logger logger = LoggerFactory.getLogger(AuditService.class);
    
    @ServiceActivator(inputChannel = "auditChannel")
    public void logAudit(Message<Audit> message) {
        logger.info("Audit entry recieved");
        logger.info(message.getPayload().toString());
    }
}
