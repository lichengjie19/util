package kafka.test;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @author licjd
 * @date 2019/9/3 16:20
 */
public class SimpleProducer {

    private static final String BROKER_LIST = "100.73.18.55:9092,100.73.18.56:9092,100.73.18.57:9092";
    public static final String TOPIC_NAME = "SIMPLE_KAFKA_TEST";

    private static KafkaProducer<String, String> producer;

    static {
        Properties props = initConfig();
        producer = new KafkaProducer(props);
    }

    public static Properties initConfig () {

        Properties props = new Properties();
        props.put("bootstrap.servers", BROKER_LIST);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return props;
    }

    public static void main(String[] args) {

        ProducerRecord<String,String> producerRecord=null;
        for(int i=0;i<5;i++) {
            producerRecord=new ProducerRecord(TOPIC_NAME,Integer.toString(i),Integer.toString(i));
            producer.send(producerRecord,new Callback() {

                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    // TODO Auto-generated method stub
                    if (null != e){
                        System.out.println("send error" + e.getMessage());
                        // log.info(send error + e.getMessage());
                    }else {
                        System.out.println(String.format("offset:%s,partition:%s",recordMetadata.offset(),recordMetadata.partition()));
                    }
                }
            });
//        	logger.info(send topic: my-topic ,key:+Integer.toString(i)+value: +Integer.toString(i));
            //System.out.println(send topic: my-topic ,key:+Integer.toString(i)+value: +Integer.toString(i));
        }
        producer.close();
    }

}
