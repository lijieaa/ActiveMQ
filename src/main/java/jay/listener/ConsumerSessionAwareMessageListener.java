package jay.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;


/**
 * Created by Administrator on 2015/11/20 0020.
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    public void onMessage(TextMessage message, Session session) throws JMSException {
        System.out.println("消息内容是：" + message.getText());
        MessageProducer producer = session.createProducer(destination);
        Message textMessage = (TextMessage)session.createTextMessage("ConsumerSessionAwareMessageListener。。。");
        producer.send(textMessage);

    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
