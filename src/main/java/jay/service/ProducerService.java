package jay.service;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
public interface ProducerService {
    /**
     * ���ʹ��ı���Ϣ
     * @param destination Ŀ�ĵ�
     * @param message ��Ϣ�ı�
     */
    public void sendMessage(Destination destination,String message);

    /**
     * ����һ��ObjectMessage
     * @param destination
     * @param obj
     */
    public void sendMessage(Destination destination, Serializable obj);
}
