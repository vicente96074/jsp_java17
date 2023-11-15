package com.kojstarinnovations.conjava17.domain.event;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a deleted event
 *
 * @author balamkiche
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedEvent{

    /**
     * This constructor initializes the deleted event
     *
     * @param message the message of the deleted event
     */
    public DeletedEvent(String message) {
        this.message = message;
        this.date = LocalDateTime.now();
    }

    private String message;
    private LocalDateTime date;
}
