package com.jxy.spring.threadpool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/7/13 14:19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("异步执行任务 " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("异步执行任务+1 " + ++i);
    }
}
