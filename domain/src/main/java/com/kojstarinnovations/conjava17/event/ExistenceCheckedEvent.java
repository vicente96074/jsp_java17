package com.kojstarinnovations.conjava17.event;

import com.kojstarinnovations.conjava17.ports.output.Event;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExistenceCheckedEvent<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA> extends Event<COMPONENT, PROCESS, TRANSACTION_ID, CRITERIA>{

    public ExistenceCheckedEvent(String message, LocalDateTime date, COMPONENT component, PROCESS process, TRANSACTION_ID transactionId, CRITERIA criteria) {
        super(message, date, component, process, transactionId, criteria);
    }
}
