package jxy.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxiuya
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
