package com.jxy.jdk8.lambda.exercise;

/**
 * Info
 *
 * @author xiuya.jxy
 * @date 2017/12/27
 * @since 2017/12/27
 */
public class AndThen {

    private static Runnable andThen(Runnable a, Runnable b) {
        return () -> {
            a.run();
            b.run();
        };
    }

    public static void main(String[] args) {
        new Thread(andThen(() -> System.out.println("a"), () -> System.out.println("b"))).start();
    }
}
