package com.amol.poc.integration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InputMessage {
   
    public InputMessage(String messageId, String message) {
        this.messageId=messageId;
        this.message=message;
    }

    public String toString() {
        return "messageId : "+this.messageId+" message : "+this.message;
    }

    String messageId,message;
}
