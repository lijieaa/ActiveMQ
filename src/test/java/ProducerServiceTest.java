import jay.entity.Email;
import jay.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProducerServiceTest {

    @Autowired
    private ProducerService producerService;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Autowired
    @Qualifier("sessionAwareQueue")
    private Destination sessionAwareQueue;

    @Autowired
    @Qualifier("adapterQueue")
    private Destination adapterQueue;

    @Test
    public void testSend() {
        for (int i=0; i<2; i++) {
            producerService.sendMessage(destination, "xxxxxxxxxxx" + (i+1));
        }
    }

    @Test
    public void testSessionAwareMessageListener() {
        producerService.sendMessage(sessionAwareQueue, "测试SessionAwareMessageListener");
    }

    @Test
    public void testMessageListenerAdapter() {
        producerService.sendMessage(adapterQueue, "测试MessageListenerAdapter");
    }

    @Test
    public void testObjectMessage() {
        Email email = new Email("zhangsan@xxx.com", "主题", "内容");
        producerService.sendMessage(destination, email);
    }
}

