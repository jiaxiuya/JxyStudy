package jxy.niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SelectorTest {

    public static void main(String[] args) {

        try {

            SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 60000));
            System.out.println(channel.isConnected());
            // 创建Selector
            Selector selector = Selector.open();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);

            while (true) {
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        System.out.println("isAcceptable");
                    } else if (key.isConnectable()) {
                        System.out.println("isConnectable");
                    } else if (key.isReadable()) {
                        SocketChannel channel1 = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
                        channel1.read(byteBuffer);
                        byteBuffer.flip();
                        while (byteBuffer.hasRemaining()) {
                            byte[] array = byteBuffer.array();
                            byteBuffer.position(byteBuffer.limit());
                            System.out.println(new String(array,"GB2312"));
                        }

                    } else if (key.isWritable()) {
                        System.out.println("isWritable");
                    } else if (key.isValid()) {
                        System.out.println("isValid");
                    }
                    iterator.remove();
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
