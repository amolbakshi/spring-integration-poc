package com.amol.poc.integration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payload {
    
    String docId;
    boolean isQueryEligible,isQueryGenerated;
}
