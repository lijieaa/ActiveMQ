package jay.service;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
public interface ProducerService {
    /**
     * 发送纯文本消息
     * @param destination 目的地
     * @param message 消息文本
     */
    public void sendMessage(Destination destination,String message);

    /**
     * 发送一个ObjectMessage
     * @param destination
     * @param obj
     */
    public void sendMessage(Destination destination, Serializable obj);
}
