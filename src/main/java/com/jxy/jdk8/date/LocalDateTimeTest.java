package com.jxy.jdk8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * <类描述>
 * <LocalDateTime代表日期和时间
 * ocalDateTime是不可变的并且它的工作原理和LocalTime和LocalDate十分相似>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/12/5 10:32]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439


        //在一些额外的时区信息帮助下，它可以被转换为instant。
        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        // Instants可以被容易的转换为遗留的java.util.Date类型。
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014


        // 和java.text.NumberFormat不一样的是DateTimeFormatter是不可变的并且是类型安全的。
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);     // Nov 03, 2014 - 07:13
    }

}
