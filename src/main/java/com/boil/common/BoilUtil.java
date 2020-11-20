package com.boil.common;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-19 15:07
 */
public class BoilUtil
{
    public static List<LocalDate> getMondayAndFriday()
    {
        LocalDate now = LocalDate.now();
        return Arrays.asList(now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)), now.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));
    }

    public static int getWeeksNum()
    {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
        return LocalDateTime.now().get(weekFields.weekOfYear());
    }
}
