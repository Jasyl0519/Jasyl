package netty.study2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-14 08:50
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println(ctx.channel().remoteAddress() + "," + msg);
        ctx.writeAndFlush("from Client:" + System.currentTimeMillis());

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("来自客户端的问候");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


    public static void main(String[] args) {
        String s = "sb,sb";
        if (s.split(",").length == 0) {
            System.out.println("1111");
        }

    }

}
