package com.jxy;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/22 14:18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class testThread {
    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, blockingQueue);

        while (true) {
            poolExecutor.submit(new TestThreadRun());
            System.out.println(poolExecutor.getQueue().size());
        }


    }

    static class TestThreadRun implements Callable {

        @Override
        public Object call() throws Exception {
            while (true) {
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
