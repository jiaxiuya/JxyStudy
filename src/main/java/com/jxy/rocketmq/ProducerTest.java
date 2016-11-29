package com.jxy.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/29 14:49]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ProducerTest {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("192.168.1.112:9876"); // (1)
        producer.start(); // (2)
        for (int i = 0; i < 1000; i++) {
            try {
                Message msg = new Message("TopicTest",// topic // (3)
                        "TagA",// tag (4)
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)// body (5)
                );
                SendResult sendResult = producer.send(msg); // (6)
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }
        producer.shutdown();
    }
}
