package com.jxy.niotest.nettyserialize.msgpack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final int sendNumber;

    public EchoClientHandler(int sendNumber) {

        this.sendNumber = sendNumber;
    }

    private UserInfo[] getUserInfos() {
        UserInfo[] userInfos = new UserInfo[sendNumber];
        UserInfo userInfo;
        for (int i = 0; i < sendNumber; i++) {
            userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("ABCDEF_" + i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] userInfos = getUserInfos();
        for (int i = 0; i < sendNumber; i++) {
            ctx.write(userInfos[i]);
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive the msapack message: " + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
