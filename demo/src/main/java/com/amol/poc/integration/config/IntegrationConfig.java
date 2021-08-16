package com.amol.poc.integration.config;

import com.amol.poc.integration.gateways.InputGateway;
import com.amol.poc.integration.model.InputMessage;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {
    
    @Bean
    public ApplicationRunner runner(InputGateway inputGateway) {
        return args -> {
            while (true){
                InputMessage inputMessage = new InputMessage("001","Test message");
                Message<InputMessage> message =  MessageBuilder.withPayload(inputMessage).build();
                inputGateway.processInputMessage(message);
                Thread.sleep(5000);
            }
            
        };
    }
    
}
