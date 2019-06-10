package netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * Author: lingyou
 * date: 2019-03-30 09:46
 */
public class NioServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public NioServer() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server 启动完成");

        handleKeys();

    }

    private void handleKeys() throws IOException {

        while (true) {

            int selectNums = selector.select(30 * 1000);
            if (selectNums == 0) {
                continue;

            }
            System.out.println("选择 Channel 数量：" + selectNums);

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (!selectionKey.isValid()) {
                    continue;
                }
                handleKey(selectionKey);
            }
        }

    }

    private void handleKey(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            handleAcceptableKey(key);

        }
        if (key.isReadable()) {
            handleReadableKey(key);

        }
        if (key.isWritable()) {
            handleWritableKey(key);
        }

    }




    private void handleAcceptableKey(SelectionKey key) throws IOException {

        SocketChannel clientSocketChannel = ((ServerSocketChannel)key.channel()).accept();

        clientSocketChannel.configureBlocking(false);

        System.out.println("接受新的 Channel");

        clientSocketChannel.register(selector, SelectionKey.OP_READ,  new ArrayList<String>());
        

    }

    private void handleReadableKey(SelectionKey key) throws ClosedChannelException {
        SocketChannel clientSocketChannel = (SocketChannel)key.channel();

        ByteBuffer readBuffer = CodecUtil.read(clientSocketChannel);

        if (readBuffer == null) {
            System.out.println("断开 Channel");
            clientSocketChannel.register(selector, 0);
            return;
        }

        if (readBuffer.position() > 0) {

            String content = CodecUtil.newString(readBuffer);

            System.out.println("读取数据：" + content);

            List<String> responseQueue = (List<String>) key.attachment();
            responseQueue.add("响应：" + content);

            clientSocketChannel.register(selector, SelectionKey.OP_WRITE, key.attachment());

        }



    }

    private void handleWritableKey(SelectionKey key) throws ClosedChannelException {
        SocketChannel clientSocketChannel = (SocketChannel)key.channel();

        List<String> responseQueue = (List<String>) key.attachment();

        for (String content : responseQueue) {

            System.out.println("写入数据：" + content);

            CodecUtil.write(clientSocketChannel, content);
            
        }

        responseQueue.clear();

        clientSocketChannel.register(selector, SelectionKey.OP_READ, responseQueue);


    }

    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer();
    }

    
}
