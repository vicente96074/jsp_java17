package com.kojstarinnovations.jps17.ports.output;


/**
 *
 * @author BalamKiche
 */
public interface EventPublisher {

    /**
     * Method to publish a retrieved event
     *
     * @param event a retrieved event
     */
    void handle(Event event);
}
