package com.jxy.spring.threadpool;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/7/13 14:35]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class test {

    public static void main(String[] args) {
        taskScheduling();
    }

    private static void taskExecutor(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        context.close();
    }

    private static void taskScheduling(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulingConfig.class);

    }

}
