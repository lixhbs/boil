package com.boil.common;

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
    public static void main(String[] args) {
        String s = "#任务 [@at,nickname=陈伟杰,wx2020-11-16nweijie900]  完成水水水水";
        // 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
        // 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
      Pattern pattern = Pattern.compile("[#](.+?)\\ ");
//        Pattern pattern = Pattern.compile("\\[@at(.+?)\\]");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }

//        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
//        Matcher matcher = pattern.matcher(s);
//        if (matcher.find()) {
//            System.out.println(matcher.groupCount());
//            System.out.println(matcher.group(0));
//        }
//        System.out.println(s.replaceAll("[0-9]{4}-[0-9]{2}-[0-9]{2}", ""));
    }
}
