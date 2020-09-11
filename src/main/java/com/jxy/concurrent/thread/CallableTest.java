package com.jxy.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * <通过实现Callable创建线程>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/3/30 17:16]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Callable Thread");
        return Thread.currentThread().getName();
    }
}
