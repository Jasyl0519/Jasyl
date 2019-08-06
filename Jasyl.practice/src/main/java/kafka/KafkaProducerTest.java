package kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Description:
 * Author: lingyou
 * date: 2019-07-06 19:11
 */
public class KafkaProducerTest {
    public static final String TOPIC = "topic-demo";


    public static Properties initConfig() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "broker1:9092,broker2:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return kafkaProps;
    }

    public static void main(String[] args) {

        Properties properties = initConfig();

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, "hello, kafka!");

        //发后即忘
        producer.send(record);
        //同步
        try {
            producer.send(record).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //异步
        producer.send(record, new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception != null) {
                    System.out.println("异常: " + exception.getMessage());

                } else {
                    System.out.println(metadata.offset());
                }
            }
        });


    }
}
