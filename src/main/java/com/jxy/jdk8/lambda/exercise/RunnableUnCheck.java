package com.jxy.jdk8.lambda.exercise;

/**
 * Info
 *
 * @author xiuya.jxy
 * @date 2017/12/27
 * @since 2017/12/27
 */
public class RunnableUnCheck {

    @FunctionalInterface
    interface RunnableEx {
        void run() throws Exception;
    }

    private static Runnable uncheck(RunnableEx runnableEx) {
        return () -> {
            try {
                runnableEx.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("sfsfsfsf");
            Thread.sleep(1000);
        })).start();
    }
}
