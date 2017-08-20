package com.jxy.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/6/27 11:09]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestFor {
    public static void main(String[] args) {
        String[] names = {"jxy", "dbl", "jss"};
        List<Runnable> runnables = new ArrayList<>();
        for (String name : names) {
            runnables.add(() -> System.out.println(name));
        }

        System.out.println(runnables);

    }
}
