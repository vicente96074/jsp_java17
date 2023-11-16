package com.kojstarinnovations.conjava17.eventpublisher;

import com.kojstarinnovations.conjava17.ports.output.Event;
import com.kojstarinnovations.conjava17.ports.output.EventPublisher;

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
    public void publishCreatedEvent(Event event) {
        publishEvent(event);
    }

    /**
     * Method to publish a retrieved event
     *
     * @param event a retrieved event
     */
    @Override
    public void publishRetrievedEvent(Event event) {
        publishEvent(event);
    }

    /**
     * Method to publish an updated event
     *
     * @param event an updated event
     */
    @Override
    public void publishUpdatedEvent(Event event) {
        publishEvent(event);
    }

    /**
     * Method to publish a deleted event
     *
     * @param event a deleted event
     */
    @Override
    public void publishDeletedEvent(Event event) {
        publishEvent(event);
    }

    /**
     * Method to publish an event
     *
     * @param event the event to be published
     */
    void publishEvent(Event event){
        logger.info(String.format("[%s] [%s] [TransactionID: %s] %s: %s AT %s", event.getComponent(), event.getProcess(), event.getTransactionId(), event.getMessage(),event.getCriteria(), event.getDate()));
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
    private final Logger logger;

    {
        logger = Logger.getLogger("Event Publisher Adapter");
    }
}
