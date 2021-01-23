package com.example.steel.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author:zh
 * @desc
 */
public class DateUtils {

    public static final DateTimeFormatter TOGETHER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter STANDARD = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter STANDARD_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter STANDARD_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final int DAY_HOUR = 24;

    public static String now(DateTimeFormatter formatter){
        return LocalDateTime.now().format(formatter);
    }

    public static String now(){
        return LocalDateTime.now().format(STANDARD);
    }


    /**
     * 获取今天时间;
     * 字符串形式;
     */
    public static String getToday(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取今天时间;
     * 字符串形式;
     */
  /*  public static String getYesterDay(){
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-1*DAY_HOUR);
        return dateFormat.format(calendar.getTime());
    }*/

    public static String getDate(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy_MM_dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-1*DAY_HOUR);
        return dateFormat.format(calendar.getTime());
    }

    public static String getDateBefore(int days){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-days*DAY_HOUR);
        return dateFormat.format(calendar.getTime());
    }


    //允许负数，表示前几天
    public static String getDatePlus(String fromDate,int days){
        LocalDate date = LocalDate.parse(fromDate);
        LocalDate plus = date.plusDays(days);
        return plus.format(STANDARD_DATE);
    }

    /**
     * 获取昨日时间;
     * 字符串形式;
     */
    public static String getYesterday(){
        return getDateBefore(1);
    }

    public static String beforeYesterday(){
        return getDateBefore(2);
    }

    public static String getDateMonthBefore(){
        return getDateBefore(30);
    }

    /**
    *   描述：根据传入时间计算一天、一个月、一年前后的时间
     *       calendar.add(Calendar.YEAR, -1);//当前时间减去一年，即一年前的时间，否则一年后
     * 　　  calendar.add(Calendar.MONTH, -1);//当前时间减去一个月，即一个月前的时间，否则一月后
     * 　　  calendar.add(Calendar.DAY_OF_MONTH,-1); //当前时间减去一天，即一天前的时间，否则一天后
    *   * @param endTime
    *   return java.lang.String
    *   Author: dcl
    *   Date: 2020/2/6 16:35
    */
    public static String getBeforeTime(Date endTime,int type,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endTime);
        calendar.add(type,amount);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beginTime = sdf.format(calendar.getTime());
        return beginTime;
    }


    /**
     * 获取一个日段所有日期集合
     * @param dStart
     * @param dEnd
     * @return
     */
    public static List<Date> findDates(Date dStart, Date dEnd) {
        Calendar cStart = Calendar.getInstance();
        cStart.setTime(dStart);
        List dateList = new ArrayList();
        //别忘了，把起始日期加上
        dateList.add(dStart);
        // 此日期是否在指定日期之后
        while (dEnd.after(cStart.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cStart.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(cStart.getTime());
        }
        return dateList;
    }


    //获取当前时间(时分秒)
    public static String getTodayTime(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }


}
