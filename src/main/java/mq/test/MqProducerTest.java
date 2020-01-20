package mq.test;

import com.jiedaibao.antmq.client.exception.MQBrokerException;
import com.jiedaibao.antmq.client.exception.MQClientException;
import com.jiedaibao.antmq.client.producer.DefaultMQProducer;
import com.jiedaibao.antmq.client.producer.SendResult;
import com.jiedaibao.antmq.client.producer.SendStatus;
import com.jiedaibao.antmq.common.message.Message;
import com.jiedaibao.antmq.remoting.exception.RemotingException;

/**
 * 生产者产生消息demo
 * @author licjd
 * @date 2019/8/16 15:04
 */
public class MqProducerTest {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("pay_dpt");
        // 启动生产者
        producer.setDomain("100.73.53.250");
        producer.start();

        byte[] body = new byte[50];

        // topic和tag是生产者和消费者约束的连线，互相制定了正确的topic和tag后，消费者才能消费到消息
        Message msg = new Message("TEST_1", "TEST_1", "MQ测试demo2".getBytes());
        // 同步发送方式
        SendResult sendResult = producer.send(msg, 100000);
        // 根据返回的sendResult对象，获取发送成功或者失败的状态，消息id等信息
        SendStatus status = sendResult.getSendStatus();
        String msgId = sendResult.getMsgId();
        System.out.println("status: " + status);
        System.out.println("msgId: " + msgId);

        // 程序退出之前shutdown
        producer.shutdown();

    }

}