package com.kojstarinnovations.conjava17.ports.output;

/**
 *
 * @author BalamKiche
 */
public interface EventPublisher{

    /**
     * Method to publish a created event
     *
     * @param event a created event
     */
    void publishCreatedEvent(Event event);

    /**
     * Method to publish a retrieved event
     *
     * @param event a retrieved event
     */
    void publishRetrievedEvent(Event event);

    /**
     * Method to publish an updated event
     *
     * @param event an updated event
     */
    void publishUpdatedEvent(Event event);

    /**
     * Method to publish a deleted event
     *
     * @param event a deleted event
     */
    void publishDeletedEvent(Event event);
}
