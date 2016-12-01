package com.jxy.jdk8.lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/12/1 10:23]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestLambda {


    /**
     * 例外的透明度，这样是不允许的,只运行在内部处理异常
     *
     * @param values
     * @param out
     */
    void appendAll(Iterable<String> values, Appendable out) { // doesn't help with the error
        values.forEach(s -> {
            // error: can't throw IOException here Consumer.accept(T) doesn't allow it
            try {
                out.append(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 不允许修改捕获的变量
     */
    void nonFinal() {
        int count = 0;
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> {
            System.out.println(count);
            // error: can't modify the value of count
//            count++;

        });

    }


    final String secret = "foo";

    /**
     * 不可以中途break return
     *
     * @param values
     * @return
     */
    boolean containsSecret(Iterable<String> values) {
        values.forEach(s -> {
            if (secret.equals(s)) {
                // want to end the loop and return true, but can't
            }
        });
        return true;
    }

    static void forEachMap() {
        Map<String, String> m = new HashMap<>();
        m.put("1", "1");
        m.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void main(String[] args) {
        forEachMap();
    }

}
