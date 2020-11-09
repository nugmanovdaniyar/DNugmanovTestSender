package ru.nugmanov.DNugmanovTestSender.sender;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import ru.nugmanov.DNugmanovTestSender.model.Message;
import ru.nugmanov.DNugmanovTestSender.service.MessageSenderService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SenderTest {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MessageSenderService messageSenderService;

    @Test
    void test() {
        String queueName = "testQueue";
        Message message = new Message(123, new Date(), "value1");
        messageSenderService.sendMessage(queueName, message);
        Object messageObj = this.jmsTemplate.receiveAndConvert(queueName);
        assertNotNull(messageObj);
        assertEquals(messageObj.getClass(), Message.class);
        Message actualMessage = (Message) messageObj;
        assertEquals(actualMessage.getNumber(), message.getNumber());
        assertEquals(actualMessage.getDate(), message.getDate());
        assertEquals(actualMessage.getText(), message.getText());
    }
}
