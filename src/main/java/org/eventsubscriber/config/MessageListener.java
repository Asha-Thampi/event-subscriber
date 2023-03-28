package org.eventsubscriber.config;


import org.eventsubscriber.model.EventModel;
import org.eventsubscriber.processor.EventProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    EventProcessor eventProcessor;

    @RabbitListener(queues = {"${rabbit.quorom.team.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveQuoromTeamQueue(EventModel eventModel) {
        eventProcessor.processMessage("team queue", eventModel);
    }


    @RabbitListener(queues = {"${rabbit.quorom.developer.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveQuoromDeveloperQueue(EventModel eventModel) {
        eventProcessor.processMessage("developer queue",eventModel);
    }

    @RabbitListener(queues = {"${rabbit.quorom.devops.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveQuoromDevopsQueue(EventModel eventModel) {
        eventProcessor.processMessage("devops queue",eventModel);
    }

    @RabbitListener(queues = {"${rabbit.quorom.tester.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveQuoromTesterQueue(EventModel eventModel) {
        eventProcessor.processMessage("tester queue", eventModel);
    }

    @RabbitListener(queues = {"${rabbit.quorom.manager.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveQuoromManagerQueue(String message) {
        eventProcessor.processHeaderExchangeMessage("manager queue", message);
    }

    @RabbitListener(queues = {"${rabbit.stream.queue.name}"}, messageConverter = "Jackson2JsonMessageConverter")
    public void receiveStreamQueue(String message) {
        eventProcessor.processHeaderExchangeMessage("stream queue", message);
    }
}
