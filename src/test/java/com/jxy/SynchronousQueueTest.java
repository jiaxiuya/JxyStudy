package com.jxy;

import java.util.concurrent.SynchronousQueue;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/4/20 20:40]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        new Thread(() -> {
            try {
                synchronousQueue.put(new String("123"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
