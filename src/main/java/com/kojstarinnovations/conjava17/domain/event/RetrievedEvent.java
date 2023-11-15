package com.kojstarinnovations.conjava17.domain.event;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetEvent
 *
 * @author balamkiche
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetrievedEvent {

    /**
     * Event to get a resource
     *
     * @param message the message of the get event
     */
    public RetrievedEvent(String message){
        this.message = message;
        this.date = LocalDateTime.now();
    }

    private String message;
    private LocalDateTime date;
}
