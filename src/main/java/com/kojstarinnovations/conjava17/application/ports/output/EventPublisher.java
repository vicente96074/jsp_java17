package com.kojstarinnovations.conjava17.application.ports.output;

import com.kojstarinnovations.conjava17.domain.event.*;

/**
 *
 * @author BalamKiche
 */
public interface EventPublisher {

    /**
     * Method to publish a created event
     *
     * @param event a created event
     */
    void publishCreatedEvent(CreatedEvent event);

    /**
     * Method to publish a retrieved event
     *
     * @param event a retrieved event
     */
    void publishRetrievedEvent(RetrievedEvent event);

    /**
     * Method to publish an updated event
     *
     * @param event an updated event
     */
    void publishUpdatedEvent(UpdatedEvent event);

    /**
     * Method to publish a deleted event
     *
     * @param event a deleted event
     */
    void publishDeletedEvent(DeletedEvent event);
}
