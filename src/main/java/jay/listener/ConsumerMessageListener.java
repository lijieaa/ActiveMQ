package jay.listener;

import jay.entity.Email;
import org.springframework.messaging.converter.MessageConverter;

import javax.jms.*;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
public class ConsumerMessageListener implements MessageListener {

    /*private MessageConverter messageConverter;
    *//**
     * 消息到达时回调
     * @param message
     *//*
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage objMessage = (ObjectMessage) message;
            try {
                Object obj = objMessage.getObject();
                Email email = (Email) obj;
                System.out.println("接收到一个ObjectMessage，包含Email对象。");
                System.out.println(email);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public MessageConverter getMessageConverter() {
        return messageConverter;
    }

    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }*/

    public void onMessage(Message message) {
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，或者直接把onMessage方法的参数改成Message的子类TextMessage
        TextMessage textMsg = (TextMessage) message;
        System.out.println("接收到一个纯文本消息。");
        try {
            System.out.println("消息内容是：" + textMsg.getText());
            if (1 == 1) {
                throw new RuntimeException("Error");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
