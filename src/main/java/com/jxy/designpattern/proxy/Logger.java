package com.jxy.designpattern.proxy;

import java.text.DateFormat;
import java.util.Date;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Logger {
    public void beforeLog(){

        System.out.println("Start Time："  + DateFormat.getInstance().format(new Date()));
    }

    public void afterLog(){
        System.out.println("End Time："  + DateFormat.getInstance().format(new Date()));

    }
}
