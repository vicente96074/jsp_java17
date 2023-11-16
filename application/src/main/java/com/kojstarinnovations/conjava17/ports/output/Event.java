package com.kojstarinnovations.conjava17.ports.output;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Event<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA>{

    private String message;
    private LocalDateTime date;
    private COMPONENT component;
    private PROCESS process;
    private TRANSACTION_ID transactionId;
    private CRITERIA criteria;
}
