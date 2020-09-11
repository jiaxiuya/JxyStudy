package com.jxy.jdk8.date;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * <类描述>
 * Clock提供了访问当前日期和时间的方法。
 * Clock是时区敏感的并且它可以被用来替代System.currentTimeMillis进行获取当前毫秒数。
 * 同时，时间轴上的时间点是可以用类Instant来表示的。
 * Instants可以被用来创建遗留的java.util.Date对象。
 *
 * @author 贾秀亚
 * @version [版本号, 2016/12/2 16:54]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ClockTest {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
    }
}
