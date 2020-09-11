package com.jxy.jdk8.lambda;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/6/27 11:17]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface TestCollection extends Collection {

    /**
     * TODO 将action应用到filter返回true的元素上
     * @param action
     * @param filter
     * @param <T>
     */
    default <T> void forEachIf(Consumer<T> action, Predicate<T> filter) {
//        action.accept();
    }
}
