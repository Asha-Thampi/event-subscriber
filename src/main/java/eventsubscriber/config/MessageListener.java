package eventsubscriber.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;;
import eventsubscriber.model.EventModel;
import eventsubscriber.processor.EventProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    EventProcessor eventProcessor;

    @RabbitListener(queues = {"${rabbit.stream.developer.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveStreamDeveloperQueue(EventModel eventModel) {
        eventProcessor.processMessage("stream developer queue", eventModel);
    }

    @RabbitListener(queues = {"${rabbit.stream.admin.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveStreamQueue(EventModel eventModel) {
        eventProcessor.processMessage("stream admin queue", eventModel);
    }

    @RabbitListener(queues = {"${rabbit.stream.team.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveStreamTeamQueue(EventModel eventModel) {
        eventProcessor.processMessage("stream team queue", eventModel);
    }

    @RabbitListener(queues = {"${rabbit.stream.tester.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveStreamTesterQueue(EventModel eventModel) {
        eventProcessor.processMessage("stream tester queue", eventModel);
    }

    @RabbitListener(queues = {"${rabbit.stream.manager.queue.name}"})
    @JsonIgnoreProperties
    public void receiveStreamManagerQueue(String message) {
        eventProcessor.processHeaderExchangeMessage("stream manager queue", message);
    }


}
