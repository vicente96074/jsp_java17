package com.kojstarinnovations.conjava17.domain.event;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreatedEvent
 *
 * @author Augusto Vicente
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedEvent {

    /**
     * CreatedEvent constructor
     *
     * @param message the message of the created event
     */
    public CreatedEvent(String message){
        this.message = message;
        this.date = LocalDateTime.now();
    }

    private String message;
    private LocalDateTime date;
}
