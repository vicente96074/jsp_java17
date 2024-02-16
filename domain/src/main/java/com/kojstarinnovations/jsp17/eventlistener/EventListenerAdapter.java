package com.kojstarinnovations.jsp17.eventlistener;

import com.kojstarinnovations.jps17.ports.output.Event;
import com.kojstarinnovations.jps17.ports.output.EventPublisher;

import java.util.logging.Logger;

/**
 * Adapter to publish events
 *
 * @author Augusto Vicente
 */
public class EventListenerAdapter implements EventPublisher {

    /**
     * Method to publish a retrieved event
     *
     * @param event a retrieved event
     */
    @Override
    public void handle(Event event) {
        String message = String.format("[%s] [%s] [TransactionID: %s] %s: %s AT %s", event.getComponent(), event.getProcess(), event.getTransactionId(), event.getMessage(),event.getCriteria(), event.getDate());
        Logger.getLogger("EventListenerAdapter").info(message);
        publishEvent(message);
    }

    /**
     * Method to publish an event
     *
     * @param message message build from event
     */
    void publishEvent(String message){
        logger.info(message);
    }

    //Singleton pattern
    private EventListenerAdapter() {
    }

    public static EventListenerAdapter getInstance() {
        if (instance == null) {
            instance = new EventListenerAdapter();
        }
        return instance;
    }

    private static EventListenerAdapter instance = null;
    private final Logger logger;

    {
        logger = Logger.getLogger("Event Publisher Adapter");
    }


}
