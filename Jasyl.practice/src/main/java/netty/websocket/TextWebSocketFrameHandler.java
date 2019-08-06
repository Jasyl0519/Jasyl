package netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-16 22:20
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        System.out.println("收到消息：" + msg.text());

        for (int i = 0; i < 10; i++) {

            ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器返回数据" + i));
            if (i == 8) {
                ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器返回数据成功" + i));
                return;
            }
        }

        //ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间：" + LocalDateTime.now()));

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded " + ctx.channel().id().asLongText());

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved " + ctx.channel().id().asLongText());


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生: " + cause.getMessage());
        ctx.close();

    }
}


