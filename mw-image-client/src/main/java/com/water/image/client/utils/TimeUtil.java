package com.water.image.client.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by admin on 2018/2/1.
 */
public class TimeUtil {

    // ---当前日期的年，月，日，时，分，秒
    public static Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);
    int date = now.get(Calendar.DAY_OF_MONTH);
    int month = now.get(Calendar.MONTH) + 1;
    int hour = now.get(Calendar.HOUR);
    int min = now.get(Calendar.MINUTE);
    int sec = now.get(Calendar.SECOND);

    // -------------------------------日期类型转换---------------------------------------------------------------------------

    public static java.util.Date toUtilDateFromStrDateByFormat(
            String p_strDate, String p_format) throws Exception {
        java.util.Date l_date = null;
        java.text.DateFormat df = new java.text.SimpleDateFormat(p_format);
        if (p_strDate != null && (!"".equals(p_strDate)) && p_format != null
                && (!"".equals(p_format))) {
            l_date = df.parse(p_strDate);
        }
        return l_date;
    }


    public static java.sql.Date toSqlDateFromStrDate(String p_strDate)
            throws Exception {
        java.sql.Date returnDate = null;
        java.text.DateFormat sdf = new java.text.SimpleDateFormat();
        if (p_strDate != null && (!"".equals(p_strDate))) {
            returnDate = new java.sql.Date(sdf.parse(p_strDate).getTime());
        }
        return returnDate;
    }


    public static String toStrDateFromUtilDateByFormat(
            java.util.Date p_utilDate, String p_format) throws ParseException {
        String l_result = "";
        if (p_utilDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(p_format);
            l_result = sdf.format(p_utilDate);
        }
        return l_result;
    }


    public static Calendar toCalendarFromUtilDate(java.util.Date p_utilDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(p_utilDate);
        return c;
    }


    public static java.sql.Date toSqlDateFromUtilDate(java.util.Date p_utilDate) {
        java.sql.Date returnDate = null;
        if (p_utilDate != null) {
            returnDate = new java.sql.Date(p_utilDate.getTime());
        }
        return returnDate;
    }


    public static java.sql.Time toSqlTimeFromUtilDate(java.util.Date p_utilDate) {
        java.sql.Time returnDate = null;
        if (p_utilDate != null) {
            returnDate = new java.sql.Time(p_utilDate.getTime());
        }
        return returnDate;
    }


    public static java.sql.Timestamp toSqlTimestampFromUtilDate(
            java.util.Date p_utilDate) {
        java.sql.Timestamp returnDate = null;
        if (p_utilDate != null) {
            returnDate = new java.sql.Timestamp(p_utilDate.getTime());
        }
        return returnDate;
    }


    public static java.util.Date toUtilDateFromSqlDate(java.sql.Date p_sqlDate) {
        java.util.Date returnDate = null;
        if (p_sqlDate != null) {
            returnDate = new java.util.Date(p_sqlDate.getTime());
        }
        return returnDate;
    }

    // -----------------获取指定日期的年份，月份，日份，小时，分，秒，毫秒----------------------------

    public static int getYearOfDate(java.util.Date p_date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(p_date);
        return c.get(java.util.Calendar.YEAR);
    }


    public static int getMonthOfDate(java.util.Date p_date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(p_date);
        return c.get(java.util.Calendar.MONTH) + 1;
    }


    public static int getDayOfDate(java.util.Date p_date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(p_date);
        return c.get(java.util.Calendar.DAY_OF_MONTH);
    }


    public static int getHourOfDate(java.util.Date p_date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(p_date);
        return c.get(java.util.Calendar.HOUR_OF_DAY);
    }


    public static int getMinuteOfDate(java.util.Date p_date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(p_date);
        return c.get(java.util.Calendar.MINUTE);
    }


    public static int getSecondOfDate(java.util.Date p_date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(p_date);
        return c.get(java.util.Calendar.SECOND);
    }


    public static long getMillisOfDate(java.util.Date p_date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(p_date);
        return c.getTimeInMillis();
    }

    // -----------------获取当前/系统日期(指定日期格式)-----------------------------------------------------------------------------------

    public static String getNowOfDateByFormat(String p_format){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(p_format);
        String dateStr = sdf.format(d);
        return dateStr;
    }


    public static String getSystemOfDateByFormat(String p_format) {
        long time = System.currentTimeMillis();
        Date d2 = new Date();
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(p_format);
        String dateStr = sdf.format(d);
        return dateStr;
    }


    public static long getDayOfMonth(Date p_date) throws ParseException {
        int year = getYearOfDate(p_date);
        int month = getMonthOfDate(p_date) - 1;
        int day = getDayOfDate(p_date);
        int hour = getHourOfDate(p_date);
        int minute = getMinuteOfDate(p_date);
        int second = getSecondOfDate(p_date);
        Calendar l_calendar = new GregorianCalendar(year, month, day, hour,
                minute, second);
        return l_calendar.getActualMaximum(l_calendar.DAY_OF_MONTH);
    }

    // -----------------获取指定月份的第一天,最后一天
    // ---------------------------------------------------------------------------

    public static String getDateOfMonthBegin(String p_strDate, String p_format)
            throws Exception {
        java.util.Date date = toUtilDateFromStrDateByFormat(p_strDate, p_format);
        return toStrDateFromUtilDateByFormat(date, "yyyy-MM") + "-01";
    }


    public static String getDateOfMonthEnd(String p_strDate, String p_format)
            throws Exception {
        java.util.Date date = toUtilDateFromStrDateByFormat(
                getDateOfMonthBegin(p_strDate, p_format), p_format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return toStrDateFromUtilDateByFormat(calendar.getTime(), p_format);
    }

    // ----------------------日期计算---------------------------------------------------------------------------------


    public static boolean isStartDateBeforeEndDate(Date p_startDate,
                                                   Date p_endDate) throws ParseException {
        long l_startTime = getMillisOfDate(p_startDate);
        long l_endTime = getMillisOfDate(p_endDate);
        return (l_startTime - l_endTime > (long) 0) ? true : false;
    }

    public static void main(String[] args) {
        TimeUtil.getNowOfDateByFormat("yyyy-MM-dd hh:mm:ss EE");
        System.out.println(TimeUtil.getNowOfDateByFormat("yyyy-MM-dd HH:mm:ss"));
    }

}
