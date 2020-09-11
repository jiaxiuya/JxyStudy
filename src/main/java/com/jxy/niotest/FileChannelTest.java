package com.jxy.niotest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jiaxiuya
 *
 * @Date 2016/8/20 20:25.
 * @Version nothing
 */
public class FileChannelTest {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\workspace\\jvmtest\\src\\main\\java\\cn\\jxy\\niotest\\channel\\FileChannelText.txt", "rw");

            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(3);

            int read = fileChannel.read(byteBuffer);

            while (read != -1) {
                System.out.println("Read " + read);
                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    System.out.println((char) byteBuffer.get());
                }

                byteBuffer.clear();
                read = fileChannel.read(byteBuffer);
                System.out.println("Read2 " + read);
            }

            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
