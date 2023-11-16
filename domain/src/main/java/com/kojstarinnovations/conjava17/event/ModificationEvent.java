package com.kojstarinnovations.conjava17.event;

import com.kojstarinnovations.conjava17.ports.output.Event;
import lombok.*;

import java.time.LocalDateTime;

/**
 * UpdatedEvent
 *
 * @author balamkiche
 */
public class ModificationEvent<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> extends Event<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA>{

        public ModificationEvent(String message, LocalDateTime date, COMPONENT component, PROCESS process, TRANSACTION_ID transactionId, CRITERIA criteria) {
            super(message, date, component, process, transactionId, criteria);
        }
}
