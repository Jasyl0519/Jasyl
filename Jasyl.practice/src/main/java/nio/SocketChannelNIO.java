package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-02-23 下午4:09
 */
public class SocketChannelNIO {


    private static void socketChannel(){
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

            ByteBuffer byteBuffer = ByteBuffer.allocate(200);
            int byteReader = socketChannel.read(byteBuffer);

            while (byteReader != -1) {
                System.out.println("Read:" + byteReader);
                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    System.out.print((char)byteBuffer.get());
                }

                byteBuffer.clear();

                byteReader = socketChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        socketChannel();

    }
}
