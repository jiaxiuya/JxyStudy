package com.jxy.jdk8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * <类描述>
 * <LocalDate代表了一个可区分日期，e.g. 2014-03-11。
 * 它是不变的同时工作原理类似于LocalTime。>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/12/5 10:12]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);    // FRIDAY

        DateTimeFormatter germanFormatter =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);   // 2014-12-24

    }
}
