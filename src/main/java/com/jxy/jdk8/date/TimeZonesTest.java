package com.jxy.jdk8.date;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * <类描述>
 * <TimeZones被用来表示ZoneId。它们可以通过静态工厂方法访问。
 * TImeZones定义了时差，它在instants和本地日期时间转换上十分重要。
 *
 * @author 贾秀亚
 * @version [版本号, 2016/12/2 17:19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TimeZonesTest {

    /**
     * TimeZones被用来表示ZoneId。它们可以通过静态工厂方法访问。
     * TimeZones定义了时差，它在instants和本地日期时间转换上十分重要。
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(ZoneId.getAvailableZoneIds());

        // prints all available timezone ids
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        // ZoneRules[currentStandardOffset=+01:00]
        // ZoneRules[currentStandardOffset=-03:00]

    }
}
