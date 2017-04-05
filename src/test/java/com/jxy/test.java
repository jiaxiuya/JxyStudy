package com.jxy;

import java.time.LocalTime;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/22 14:18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class test {
    static volatile long a = 1L;

    private void testVolatile(){
        int nowTime = LocalTime.now().getMinute();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(a++);
            });
            thread.start();
        }
        int endTime = LocalTime.now().getMinute();
        System.out.println("time = " + (endTime - nowTime));
    }

    public static void main(String[] args) throws InterruptedException {
       new test().testVolatile();

    }
}
