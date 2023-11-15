package com.kojstarinnovations.conjava17.domain.event;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UpdatedEvent
 *
 * @author balamkiche
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedEvent {

    /**
     * UpdatedEvent
     *
     * @param message the message with the updated event
     */
    public UpdatedEvent( String message) {
        this.message = message;
        this.date = LocalDateTime.now();
    }

    private String message;
    private LocalDateTime date;
}
