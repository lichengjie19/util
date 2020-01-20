package mq.test;

import com.jiedaibao.antmq.client.consumer.DefaultMQPushConsumer;
import com.jiedaibao.antmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.jiedaibao.antmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.jiedaibao.antmq.client.consumer.listener.MessageListenerConcurrently;
import com.jiedaibao.antmq.client.exception.MQClientException;
import com.jiedaibao.antmq.common.UtilAll;
import com.jiedaibao.antmq.common.consumer.ConsumeFromWhere;
import com.jiedaibao.antmq.common.message.MessageExt;
import com.jiedaibao.antmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 消费者消费消息demo
 * @author licjd
 * @date 2019/8/16 16:05
 */
public class MqConsumerTest2 {

    public static void main(String[] args) throws MQClientException {
        // 设置一个消费组，同一个进程中不同消费组的名字不可同名，不同进程中的相同消费组均衡消费
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("pay_dpt");
        // 设置消费组消费消息的起点，CONSUME_FROM_LAST_OFFSET忽略已有的消息，CONSUME_FROM_FIRST_OFFSET不忽略
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 订阅消费组准备消费的消息topic和tag，需要和生产者生产时的消息的topic和tag对应
        consumer.subscribe("TEST_1", "*");
        consumer.setNamesrvAddr("100.73.53.250:9876");
        consumer.setMessageModel(MessageModel.BROADCASTING);
        // 注册消费消息的业务代码listenre
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                // 如果发生消费失败时，下次重试时间间隔，4代表下次重试在30s之后
                context.setDelayLevelWhenNextConsume(4);
                try {
                    for (MessageExt msg : msgs) {
                        // 记下日志，利于回查
                        System.out.println(UtilAll.timeMillisToHumanString() + ":receieved msg" + msg);
                        // 业务消费代码......
                        System.out.println(new String(msg.getBody()));

                    }
                    // 消息处理成功,已消费
                    Thread.sleep(2000);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 消费异常，mq将会进行重试
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动consumer
        consumer.start();
    }

}
