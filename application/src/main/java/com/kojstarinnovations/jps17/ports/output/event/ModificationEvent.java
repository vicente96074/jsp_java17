package com.kojstarinnovations.jps17.ports.output.event;

import com.kojstarinnovations.jps17.ports.output.Event;

import java.time.LocalDateTime;

/**
 * ModificationEvent
 *
 * @author balamkiche
 */

public class ModificationEvent<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> extends Event<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> {

    public ModificationEvent(String message, LocalDateTime date, COMPONENT component, PROCESS process, TRANSACTION_ID transactionId, CRITERIA criteria) {
        super(message, date, component, process, transactionId, criteria);
    }
}
