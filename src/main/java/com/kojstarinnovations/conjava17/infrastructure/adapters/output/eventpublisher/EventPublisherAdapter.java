package com.kojstarinnovations.conjava17.infrastructure.adapters.output.eventpublisher;

import com.kojstarinnovations.conjava17.application.ports.output.EventPublisher;
import com.kojstarinnovations.conjava17.domain.event.CreatedEvent;
import com.kojstarinnovations.conjava17.domain.event.DeletedEvent;
import com.kojstarinnovations.conjava17.domain.event.RetrievedEvent;
import com.kojstarinnovations.conjava17.domain.event.UpdatedEvent;

import java.util.logging.Logger;

/**
 * Adapter to publish events
 *
 * @author Augusto Vicente
 */
public class EventPublisherAdapter implements EventPublisher{
    /**
     * Method to publish a created event
     *
     * @param event a created event
     */
    @Override
    public void publishCreatedEvent(CreatedEvent event) {
        publishEvent(event.getClass().getName(), event);
    }

    /**
     * Method to publish a retrieved event
     *
     * @param event a retrieved event
     */
    @Override
    public void publishRetrievedEvent(RetrievedEvent event) {
        publishEvent(event.getClass().getName(), event);
    }

    /**
     * Method to publish an updated event
     *
     * @param event an updated event
     */
    @Override
    public void publishUpdatedEvent(UpdatedEvent event) {
        publishEvent(event.getClass().getName(), event);
    }

    /**
     * Method to publish a deleted event
     *
     * @param event a deleted event
     */
    @Override
    public void publishDeletedEvent(DeletedEvent event) {
        publishEvent(event.getClass().getName(), event);
    }

    void publishEvent(String className, Object event){
        Logger.getLogger(className).info(event.toString());
    }

    //Singleton pattern
    private EventPublisherAdapter() {
    }

    public static EventPublisherAdapter getInstance() {
        if (instance == null) {
            instance = new EventPublisherAdapter();
        }
        return instance;
    }

    private static EventPublisherAdapter instance = null;

}
