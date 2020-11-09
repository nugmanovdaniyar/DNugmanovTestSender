package ru.nugmanov.DNugmanovTestSender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.nugmanov.DNugmanovTestSender.model.Message;

/**
 * Сервис для отправки сообщений о чередь в формате xml
 *
 * @author NugmanovDT, 04.11.2020
 */
@Service
public class MessageSenderService {
    private final JmsTemplate jmsTemplate;

    @Value("${message.queue.name}")
    private String queueName;

    public MessageSenderService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * Отправляет сообщение в очередь
     */
    public void sendMessage(String queueName, final Message message) {
        jmsTemplate.convertAndSend(queueName, message);
    }
}