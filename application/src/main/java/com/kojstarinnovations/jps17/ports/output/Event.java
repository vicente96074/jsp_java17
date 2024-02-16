package com.kojstarinnovations.jps17.ports.output;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Class definition for the Event
 *
 * @param <COMPONENT>
 * @param <PROCESS>
 * @param <TRANSACTION_ID>
 * @param <CRITERIA>
 *
 * @author Augusto Vicente
 */
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