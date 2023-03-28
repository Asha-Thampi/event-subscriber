package org.eventsubscriber.processor;

import com.messageBroker.eventsubscriber.model.EventModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventProcessor.class);

    public void processMessage(String sourceQueue, EventModel eventModel) {
        LOGGER.info("Received message from " + sourceQueue + ": Id is " + eventModel.getId() + " and message is " + eventModel.getMessage());
    }

    public void processHeaderExchangeMessage(String sourceQueue, String message) {
        LOGGER.info("Received message from " + sourceQueue + ":" + message);
    }
}
