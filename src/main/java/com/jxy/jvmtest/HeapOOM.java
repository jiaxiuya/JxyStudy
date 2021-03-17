package com.jxy.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @Date 2016/5/11 19:25.
 * @Version nothing
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {

        List<OOMObject> oomObjectList = new ArrayList<>();

        while (true) {
            oomObjectList.add(new OOMObject());
        }

    }
}
