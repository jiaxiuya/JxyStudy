package com.jxy.spring.controlleradvice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/7/20 15:03]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class AdviceController {
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj demoObj) {
        throw new IllegalArgumentException("非常抱歉，参数有误/来自@modelAttribute:" + msg +"\ndemoObj:" + demoObj.toString());
    }
}
