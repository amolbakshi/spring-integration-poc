package com.amol.poc.integration.gateways;

import com.amol.poc.integration.model.Audit;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface AuditGateway {
    @Gateway(requestChannel = "auditChannel")
    public void logAudit(Message<Audit> message);
}
