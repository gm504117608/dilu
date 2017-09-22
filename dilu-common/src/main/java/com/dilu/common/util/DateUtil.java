package com.dilu.common.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guonima
 * @create 2017-09-21 18:33
 */
public class DateUtil {

    public final static String PATTERN_SHORT_RAIL = "yyyy-MM-dd";

    public final static String PATTERN_SHORT_OBLIQUE = "yyyy/MM/dd";

    public final static String PATTERN_SHORT_NO_LINE = "yyyyMMdd";

    public final static String PATTERN_LONG_RAIL = "yyyy-MM-dd HH:mm:ss";

    public final static String PATTERN_LONG_OBLIQUE = "yyyy/MM/dd HH:mm:ss";

    public final static String PATTERN_LONG_NO_LINE = "yyyyMMddHHmmss";

    private DateUtil() { }

    /**
     * 计算两个给定的日期之间含有多少天
     * 返回一个集合，集合的内容包含两个日期之间的所有天数的Date
     *
     * @param d1 开始日期
     * @param d2 结束日期
     * @return
     */
    public static List<Date> calculateBetweenDatesOfDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return null;
        }
        if (d1.compareTo(d2) >= 0) {
            return null;
        }
        DateTime dt1 = new DateTime(d1);
        DateTime dt2 = new DateTime(d2);
        List<Date> list = new ArrayList<Date>();
        while (dt1.compareTo(dt2) < 0) {
            list.add(dt1.toDate());
            dt1 = dt1.plusDays(1);
        }
        return list;
    }

    /**
     * 计算两个给定的日期之间含有多少天
     * 返回一个集合，集合的内容包含两个日期之间的所有天数的字符串（日期格式为 yyyy-MM-dd）
     * 例如： 2017-01-01 至 2017-01-03 返回 {"2017-01-01", "2017-01-02"}
     *
     * @param d1 开始日期
     * @param d2 结束日期
     * @return
     */
    public static List<String> calculateBetweenDatesOfString(Date d1, Date d2, String pattern) {
        List<Date> list = calculateBetweenDatesOfDate(d1, d2);
        List<String> result = new ArrayList<String>();
        for (Date date : list) {
            result.add(format(date, pattern));
        }
        return result;
    }

    /**
     * 计算两个给定的日期之间含有多少天
     * 返回一个集合，集合的内容包含两个日期之间的所有天数的字符串（日期格式为 yyyy-MM-dd）
     * 例如： 2017-01-01 至 2017-01-03 返回 {"2017-01-01", "2017-01-02"}
     *
     * @param d1 开始日期
     * @param d2 结束日期
     * @return
     */
    public static List<String> calculateBetweenDatesOfString(Date d1, Date d2) {
        return calculateBetweenDatesOfString(d1, d2, PATTERN_SHORT_RAIL);
    }

    /**
     * 计算两个给定的日期之间含有多少天
     * 返回一个集合，集合的内容包含两个日期之间的所有天数的字符串（日期格式为 yyyy-MM-dd）
     * 例如： 2017-01-01 至 2017-01-03 返回 {"2017-01-01", "2017-01-02"}
     *
     * @param d1 开始日期
     * @param d2 结束日期
     * @return
     */
    public static List<String> calculateBetweenDatesOfString(String d1, String d2) {
        return calculateBetweenDatesOfString(parse(d1), parse(d2), PATTERN_SHORT_RAIL);
    }

    public static List<String> calculateBetweenDatesOfString(String d1, String d2, String pattern) {
        return calculateBetweenDatesOfString(parse(d1), parse(d2), pattern);
    }

    /**
     * 将string型日期转为date日期
     *
     * @param date
     * @return
     */
    public static Date parse(String date, String pattern) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将string型日期转为date日期
     *
     * @param date
     * @return
     */
    public static Date parse(String date) {
        return parse(date, PATTERN_SHORT_RAIL);
    }

    /**
     * 将date型日期转为String日期
     *
     * @param date
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将date型日期转为String日期
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, PATTERN_SHORT_RAIL);
    }


    /**
     * 计算两个时间的间隔 秒数/分钟数/小时数/天数/月数/年数
     *
     * @param d1  开始时间
     * @param d2  结束时间
     * @param str 计算类型标志
     * @return
     */
    public static long datesOfTime(String d1, String d2, String str) {
        return datesOfTime(parse(d1), parse(d2), str);
    }

    /**
     * 计算两个时间的间隔 秒数/分钟数/小时数/天数/月数/年数
     *
     * @param d1  开始时间
     * @param d2  结束时间
     * @param str 计算类型标志
     * @return
     */
    public static long datesOfTime(Date d1, Date d2, String str) {
        if (StringUtils.isEmpty(str)) {
            str = "second";
        }
        if (null == d1 || d2 == null) {
            throw new NullPointerException("传入的日期不能为空");
        }
        long t1 = d1.getTime();
        long t2 = d2.getTime();
        long result = 0L;
        switch (str) {
            case "second":
                result = Math.abs((t1 - t2) / 1000);
                break;
            case "minute":
                result = Math.abs((t1 - t2) / 1000 / 60);
                break;
            case "hour":
                result = Math.abs((t1 - t2) / 1000 / 60 / 60);
                break;
            case "day":
                result = Math.abs((t1 - t2) / 1000 / 60 / 60 / 24);
                break;
            case "month":
                result = Math.abs((t1 - t2) / 1000 / 60 / 60 / 24 / 12);
                break;
            case "year":
                result = Math.abs((t1 - t2) / 1000 / 60 / 60 / 24 / 12 / 365);
                break;
            default:
                result = 0L;
                break;
        }
        return result;
    }

    /**
     * 比较两个日期的大小， 如果d1 大于等于d2 则为true 否则 false
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean compareTo(Date d1, Date d2) {
        return d1.compareTo(d2) >= 0 ? true : false;
    }

    /**
     * 计算某个时间加上n天之后的时间
     *
     * @param d1
     * @param days
     * @return
     */
    public static Date plusDays(Date d1, int days) {
        DateTime dt1 = new DateTime(d1);
        return dt1.plusDays(days).toDate();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNowDate() {
        return parse(format(new Date()));
    }
}
