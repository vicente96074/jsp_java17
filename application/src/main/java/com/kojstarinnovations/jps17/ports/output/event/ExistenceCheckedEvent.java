package com.kojstarinnovations.jps17.ports.output.event;

import com.kojstarinnovations.jps17.ports.output.Event;

import java.time.LocalDateTime;

/**
 * ExistenceCheckedEvent
 *
 * @author Augusto Vicente
 */
public class ExistenceCheckedEvent<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> extends Event<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> {
    public ExistenceCheckedEvent(String message, LocalDateTime date, COMPONENT component, PROCESS process, TRANSACTION_ID transactionId, CRITERIA criteria) {
        super(message, date, component, process, transactionId, criteria);
    }
}
