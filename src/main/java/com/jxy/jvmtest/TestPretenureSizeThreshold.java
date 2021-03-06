package com.jxy.jvmtest;

/**
 * Info
 *
 * @author xiuya.jxy
 * @since 2021/3/17
 */
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        //直接分配在老年代中 }
        allocation = new byte[4 * _1MB];
    }
}
