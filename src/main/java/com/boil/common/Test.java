package com.boil.common;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-16 18:07
 */
public class Test
{
//    public static void main(String[] args) {
//        String s = "#任务 [@at,nickname=陈伟杰,wx2020-11-16nweijie900]  完成水水水水";
//        // 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
//        // 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
//      Pattern pattern = Pattern.compile("[#](.+?)\\ ");
////        Pattern pattern = Pattern.compile("\\[@at(.+?)\\]");
//        Matcher matcher = pattern.matcher(s);
//        if(matcher.find()){
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//        }
//
////        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
////        Matcher matcher = pattern.matcher(s);
////        if (matcher.find()) {
////            System.out.println(matcher.groupCount());
////            System.out.println(matcher.group(0));
////        }
////        System.out.println(s.replaceAll("[0-9]{4}-[0-9]{2}-[0-9]{2}", ""));
//    }

    public static void main(String[] a){
//        //获取当前时间
//        LocalDateTime currentDate = LocalDateTime.now();
//        //获取年份
//        int year = currentDate.getYear();
//        System.out.println("获取当前年份:" + year);
//        //获取月份
//        int month = currentDate.getMonthValue();
//        System.out.println("获取当前月份:" + month);
//        //获取当前周
//        int week = currentDate.getDayOfWeek().getValue();
//        System.out.println("获取当前周:" + week);
        //获取当前时间第X周
        /*
        public static WeekFields of​(DayOfWeek firstDayOfWeek, int minimalDaysInFirstWeek)
        从第一天和最小日期获得WeekFields的实例。
        第一天的每周定义ISO DayOfWeek ，即一周中的第一天。 第一周的最小天数定义一个月或一年中必须存在的天数，从第一天开始，在将一周计算为第一周之前。 值1将计算作为第一周的一部分的月或年的第一天，而值7将要求整个七天在新的月或年中。

        WeekFields实例是单例; 对于firstDayOfWeek和minimalDaysInFirstWeek的每个唯一组合，将返回相同的实例。

        参数
        firstDayOfWeek - 一周的第一天，不是null
        minimalDaysInFirstWeek - 第一周的最小天数，从1到7
         */
//        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
//        int weeks = currentDate.get(weekFields.weekOfYear());
//        System.out.println("获取当前时间第" + weeks + "周");
//
//        LocalDate now = LocalDate.now().plusDays(1);
//        System.out.println("当前日期: " + now + " " + now.getDayOfWeek());
//        // 求这个日期上一周的周一、周日
//        LocalDate monday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
//        LocalDate sunday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
//        System.out.println("当前日期：" + now + " 周一：" + monday + " " + monday.getDayOfWeek());
//        System.out.println("当前日期：" + now + " 周日：" + sunday + " " + sunday.getDayOfWeek());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1").append(2).append(3).insert(0, "yi");
        System.out.println("stringBuilder.toString() = " + stringBuilder.toString());


        System.out.println(LocalDate.now().getDayOfMonth());
    }
}
