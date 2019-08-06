package netty.study3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-16 20:50
 */
public class MyChatClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            //future.channel().closeFuture().sync();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (;;) {
                channel.writeAndFlush(br.readLine() + "\r\n");
                
                
            }

        } finally {
            eventLoopGroup.shutdownGracefully();

        }
    }
}
