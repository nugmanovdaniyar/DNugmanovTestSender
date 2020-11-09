package ru.nugmanov.DNugmanovTestSender.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.*;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.nugmanov.DNugmanovTestSender.model.Message;

/**
 * Конфигурация Jms
 *
 * @author NugmanovDT, 04.11.2020
 */
@EnableJms
@Configuration
public class JmsConfiguration {

    /**
     * @return JmsTemplate с конвертором в формат xml
     */
    @Bean
    public JmsTemplate orderJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(new ActiveMQConnectionFactory());
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Message.class);
        MarshallingMessageConverter converter = new MarshallingMessageConverter(jaxb2Marshaller, jaxb2Marshaller);
        jmsTemplate.setMessageConverter(converter);

        return jmsTemplate;
    }
}
