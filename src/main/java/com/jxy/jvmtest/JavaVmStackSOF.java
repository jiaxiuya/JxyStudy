package com.jxy.jvmtest;

/**
 * Created by jiaxiuya
 *
 * @VM Args -Xss128K
 * @Date 2016/5/11 20:29.
 * @Version nothing
 */
public class JavaVmStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVmStackSOF javaVmStackSOF = new JavaVmStackSOF();
        try {
            javaVmStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length: " + javaVmStackSOF.stackLength);
            throw e;
        }
    }
}

