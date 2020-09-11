package com.jxy.niotest.niotimeservice;

/**
 * Created by jiaxiuya
 *
 * @Date 2016/8/26 1:39.
 * @Version nothing
 */
public class TimeServerNio {

    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
