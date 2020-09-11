package com.jxy;

import java.util.concurrent.locks.LockSupport;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/4/20 13:40]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LockSupportTest {

    public static void main(String[] args) {
        LockSupport.park();
        System.out.printf("123");
        LockSupport.unpark(Thread.currentThread());
    }
}
