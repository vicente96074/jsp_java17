package com.kojstarinnovations.jps17.ports.output.event;

import com.kojstarinnovations.jps17.ports.output.Event;

import java.time.LocalDateTime;

/**
 * EnrollingEvent
 *
 * @author Augusto Vicente
 */
public class EnrollingEvent<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> extends Event<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> {

    public EnrollingEvent(String message, LocalDateTime date, COMPONENT component, PROCESS process, TRANSACTION_ID transactionId, CRITERIA criteria) {
        super(message, date, component, process, transactionId, criteria);
    }

}
