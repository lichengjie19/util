package kafka.test;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;

import java.util.Properties;

/**
 * @author licjd
 * @date 2019/9/4 17:13
 */
public class CreateKafkaTopic {

    public static final String TOPIC_NAME_DEMO = "SIMPLE_KAFKA_TEST";

    public static void main(String[] args) {
        ZkUtils zkUtils = ZkUtils.apply("100.73.18.55:2181,100.73.18.56:2181,100.73.18.57:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
        // 创建一个单分区单副本名为t1的topic
        AdminUtils.createTopic(zkUtils, CreateKafkaTopic.TOPIC_NAME_DEMO, 1, 1, new Properties());
        zkUtils.close();
    }

}
