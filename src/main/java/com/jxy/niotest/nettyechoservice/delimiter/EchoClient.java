package com.jxy.niotest.nettyechoservice.delimiter;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class EchoClient {

    public static void main(String[] args) {
        int port = 8080;
        try {
            new EchoClient().connect(port,"127.0.0.1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建客户端连接
     *
     * @param port
     * @param host
     */
    public void connect(int port, String host) throws InterruptedException {
        // 客户端工作NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建并初始化引导程序
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new EchoClientHandler());

                        }
                    });

            // 用初始化工具创建连接
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            // 异步等待客户端关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }
}
