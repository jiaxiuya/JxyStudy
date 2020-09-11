package com.jxy.niotest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TransferFromTest {

    public static void main(String[] args) {
        try {

            RandomAccessFile fromFile = new RandomAccessFile("D:\\workspace\\JxyStudy\\com\\jxy\\niotest\\fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("D:\\workspace\\JxyStudy\\com\\jxy\\niotest\\toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel, position, count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}