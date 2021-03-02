package com.gaoce.whatever;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProcessingTime {

    /**
     *
     时间向下取整
     */

    public static String getInitialTime(int interval, Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String format = sdf.format(date);
        //String timestr = DateUtil.formatDate(date,"yyyy-MM-dd-HH-mm-ss");
        String minute = format.split("-")[4];
        String initMinute = minute+"";
        if(interval>0){
            initMinute = ((Integer.parseInt(minute)/interval)*interval)%60+"";
        }
        String nextTime = getTimeByMinutedown(date);
        if(initMinute.length()<2){
            return nextTime+"0"+initMinute;
        }
        return nextTime+""+initMinute;
    }

    /**
     * 获取指定N分钟前/后的时间(精确到小时)
     * @param minute
     * @return
     */
    public static String getTimeByMinute(int minute,Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat("yyyyMMddHH").format(calendar.getTime());
    }


    /**
     * 获取指定N分钟后的时间(精确到小时)
     * @param
     * @return
     */
    public static String getTimeByMinutedown(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
      //  calendar.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat("yyyyMMddHH").format(date.getTime());
    }
    /**
     * 将时间戳转化为时间
     * @param time
     * @return
     */
    public static Date getTimeByTimestamp(long time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String format = sdf.format(new Date(Long.valueOf(time + "000")));
        Date startDate = sdf.parse(format);
        return startDate;
    }


    /**
     * 将时间转化为时间戳
     * @param time
     * @return
     */
    public static Date getTimestampByTime(String time) throws ParseException {
        SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat("yyyyMMddHHmm");
        Date parse = yyyyMMddHHmm.parse(time);

        return parse;
    }


    public static Date getWholeByTime(Date starttime) throws ParseException {
        //Date starttime = ProcessingTime.getTimeByTimestamp(time);
        String initialTime = ProcessingTime.getInitialTime(5, starttime);
        Date timestampByTime = ProcessingTime.getTimestampByTime(initialTime);
        return timestampByTime;
    }
}
