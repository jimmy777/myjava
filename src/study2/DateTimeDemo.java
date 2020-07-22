package study2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeDemo {
    public static void main(String[] args) {
        // 自从 1970年1月1日0时0分0秒（UTC 时间）
//        Date date = new Date(Long.MAX_VALUE);
//        System.out.println("Java8 time overflows on " + date);

        // 获取当前日期和时间
//        LocalDate dNow = LocalDate.now();
//        System.out.println(dNow);
//        LocalTime tNow = LocalTime.now();
//        System.out.println(tNow);
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);

        // 格式化日期
        // 自定义日期显示格式。
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/LL/dd");
//        System.out.println(df.format(LocalDateTime.now()));
//        // 字符串转化成日期。
//        System.out.println(LocalDate.parse("2014/04/01", df));
//        // 格式化显示，去掉时区。
//        DateTimeFormatter nTZ = DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
//        System.out.println(ZonedDateTime.now().format(nTZ));

        // 两个日期的差值
//        LocalDate endofCentury = LocalDate.of(2000, 12, 31);
//        LocalDate now = LocalDate.now();
//
//        Period diff = Period.between(endofCentury, now);
//
//        System.out.printf("The 21st century (up to %s) is %s old.\n", now, diff);
//        System.out.printf("The 21st Century is %d years, %d months and %d days old.", diff.getYears(), diff.getMonths(),diff.getDays());


        /*
            今天的日期加上 700 天后的日期。
         */
//        LocalDate now = LocalDate.now();
//        Period p = Period.ofDays(700);
//        LocalDate then = now.plus(p);
//
//        System.out.printf("Seven hundred days form %s is %s\n", now, then);

        // 旧 API 类 Date 和 Calendar 的转换。
        Date legacyDate = new Date();
        System.out.println(legacyDate);

        LocalDateTime newDate = LocalDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        System.out.println(newDate);

        Calendar c = Calendar.getInstance();
        System.out.println(c);
        LocalDateTime newCal = LocalDateTime.ofInstant(c.toInstant(), ZoneId.systemDefault());
        System.out.println(newCal);

    }
}
