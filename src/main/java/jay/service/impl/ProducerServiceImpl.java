package jay.service.impl;

import jay.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
@Component
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("responseQueue")
    private Destination responseDestination;

    public void sendMessage(Destination destination, final String message) {

        jmsTemplate.send(destination, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                /*TextMessage textMessage = session.createTextMessage(message);
                textMessage.setJMSReplyTo(responseDestination);*/
                return session.createTextMessage(message);
            }

        });
    }

    public void sendMessage(Destination destination, final Serializable obj) {

        /*jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objMessage = session.createObjectMessage(obj);
                return objMessage;
            }

        });*/

        jmsTemplate.convertAndSend(destination, obj);
    }
}
