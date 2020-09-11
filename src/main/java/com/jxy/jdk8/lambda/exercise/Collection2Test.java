package com.jxy.jdk8.lambda.exercise;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Info
 *
 * @author xiuya.jxy
 * @date 2017/12/27
 * @since 2017/12/27
 */
public class Collection2Test {

    interface Collection2<T> extends Collection<T> {

        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            forEach(item -> {
                if (filter.test(item)) {
                    action.accept(item);
                }
            });
        }

    }

}
