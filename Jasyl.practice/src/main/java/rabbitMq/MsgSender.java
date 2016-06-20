package rabbitMq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by jason on 16/6/1.
 */
public class MsgSender {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "hello world!";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        System.out.println("[X] sent " + message );

        channel.close();
        channel.close();



    }
}
