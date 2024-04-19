package com.example.iosdialogdemo.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hs on 2018-12-24.
 */
public class DateUtils {


    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }


    public static String getNowTime(){
        SimpleDateFormat time_Format = new SimpleDateFormat("MM-dd HH:mm:ss");
        return time_Format.format(new Date());
    }

    public static String getNowDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }


    public static String getNyr(){
        SimpleDateFormat nyrxqFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return nyrxqFormat.format(new Date())+" "+getWeekOfDate(new Date());
    }

    public static String getBarTime(){
        SimpleDateFormat barTimeFormat = new SimpleDateFormat("HH:mm:ss");
        return barTimeFormat.format(new Date());
    }


    public static String getReportTime(){
        SimpleDateFormat bzTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return bzTimeFormat.format(new Date());
    }

    public static String getCreateTime(){
        SimpleDateFormat createTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return createTimeFormat.format(new Date());
    }

    public static String getSfTime(){
        SimpleDateFormat sfTimeFormat = new SimpleDateFormat("HH:mm");
        return sfTimeFormat.format(new Date());
    }

    public static String getNaxtDate(){
        SimpleDateFormat createTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.add(Calendar.DATE, 1);// num为增加的天数，可以改变的
        Date nextDate = ca.getTime();
        return createTimeFormat.format(nextDate);
    }

    public static String getSetTimeDate(String time){
        try{
            SimpleDateFormat setTimeFormat = new SimpleDateFormat("yyyyMMddHHmm");
            SimpleDateFormat createTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=setTimeFormat.parse(time);
            return createTimeFormat.format(date);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    public static String getRightText(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String timeStr=timeFormat.format(new Date());
        return  timeStr;
    }

}
