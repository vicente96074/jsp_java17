package com.kojstarinnovations.conjava17.event;

import java.time.LocalDateTime;

import com.kojstarinnovations.conjava17.ports.output.Event;
import lombok.*;

/**
 * GetEvent
 *
 * @author balamkiche
 */
public class DisplayEvent<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> extends Event<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA>{
    public DisplayEvent(String message, LocalDateTime date, COMPONENT component, PROCESS process, TRANSACTION_ID transactionId, CRITERIA criteria) {
        super(message, date, component, process, transactionId, criteria);
    }
}
