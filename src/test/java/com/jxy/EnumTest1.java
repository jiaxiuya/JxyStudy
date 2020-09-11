package com.jxy;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/3/17 0:42]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum EnumTest1 {

    INT_ONE(1),

    INT_TWO(2);

    private int value;

    private EnumTest1(int value) {
        this.value = value;
    }

    private int getValue() {
        return this.value;
    }

}
