package com.jxy.jdk8.annotations;

import java.lang.annotation.Repeatable;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/12/5 10:58]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Repeatable(Hints.class)
@interface Hint {
    String value();
}
