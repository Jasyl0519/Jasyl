package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Description:
 * Author: lingyou
 * date: 2019-07-06 19:11
 */
public class KafkaConsumerTest {
    public static final String TOPIC = "topic-demo";
    public static final String BROKER_LIST = "broker1:9092,broker2:9092";
    public static final String GROUP_ID = "group.demo";
    public static final String CLIENT_ID = "consumer.client.id.demo";
    public static final AtomicBoolean IS_RUNNING = new AtomicBoolean(true);


    public static Properties initConfig() {
        Properties kafkaProps = new Properties();
        kafkaProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        kafkaProps.put(ConsumerConfig.CLIENT_ID_CONFIG, CLIENT_ID);
        kafkaProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        return kafkaProps;
    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE + 2);
        System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);

        //Properties properties = initConfig();
        //
        //KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        //consumer.subscribe(Arrays.asList(TOPIC));
        //
        //try {          RangeAssignor
        //    while (IS_RUNNING.get()) {
        //        ConsumerRecords<String, String> records = consumer.poll(1000);
        //        for (ConsumerRecord<String, String> record : records) {
        //            System.out.println(record.topic() + record.partition() + record.offset());
        //            System.out.println(record.key() + record.value());
        //
        //        }
        //
        //    }
        //} catch (Exception e) {
        //    e.printStackTrace();
        //} finally {
        //    consumer.close();
        //}


    }
}
