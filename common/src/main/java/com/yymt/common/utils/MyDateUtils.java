package com.yymt.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * ClassName:MyDateUtils
 * Description:日期操作类工具。
 * author hgq
 */  
public class MyDateUtils {
  
	    private final static String DATE_FORMAT = "yyyy-MM-dd";  
	    private final static String DATE_FORMAT_CN = "yyyy年MM月dd日";  
	    private final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	    private final static String DATE_TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
	    private final static String MONTH_FORMAT = "yyyy-MM";  
	    private final static String DAY_FORMAT = "yyyyMMdd";

	    /**
	     * String 转 Date
	     * @param string
	     * @return
	     */
	    public static Date strToDate(String string,String fmt) {
			Date date = null;
			try {
				date = DateUtils.parseDate(string, fmt);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}

	    /**
	     * 指定月份第一天
	     * @param date
	     * @return
	     */
	    public static String getSpecifiedMonthFirstDay(String date) {
	    	Calendar cal = Calendar.getInstance();  
	        try {  
	            cal.setTime(DateUtils.parseDate(date, MONTH_FORMAT));  
	            cal.set(Calendar.DATE, 1); 
	        } catch (Exception e1) {  
	            e1.printStackTrace();  
	        }  
		    return DateFormatUtils.format(cal, DATE_FORMAT);
	    }
	    
	    /**
	     * 指定月份最后一天
	     * @param date
	     * @return
	     */
	    public static String getSpecifiedMonthLastDay(String date) {  
	    	Calendar cal = Calendar.getInstance();  
	        try {  
	        	Calendar f = (Calendar) cal.clone();  
	 	        f.clear(); 
	            cal.setTime(DateUtils.parseDate(date, MONTH_FORMAT));  
	            cal.set(Calendar.DATE, 1);// 设为当前月的1号  
		        cal.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号  
		        cal.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天 
	        } catch (Exception e1) {  
	            e1.printStackTrace();  
	        }  
		    return DateFormatUtils.format(cal, DATE_FORMAT);
	    }
	    /** 
	     * Title:getMonthFirstDay
	     * Description: 得到当前月的第一天.
	     * @return String
	     */  
	    public static String getMonthFirstDay() {  
	        Calendar cal = Calendar.getInstance();  
	        // 方法一,默认只设置到年和月份.  
	        // Calendar f = (Calendar) cal.clone();  
	        // f.clear();  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH));  
	        // f.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DATE));  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法二.  
	        cal.set(Calendar.DATE, 1);  
	        return DateFormatUtils.format(cal, DATE_FORMAT);  
	  
	    }  
	  
	    /** 
	     * Title:getMonthLastDay
	     * Description: 得到当前月最后一天
	     * @return String
	     */  
	    public static String getMonthLastDay() {  
	        Calendar cal = Calendar.getInstance();  
	        Calendar f = (Calendar) cal.clone();  
	        f.clear();  
	        // 方法一  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);  
	        // f.set(Calendar.MILLISECOND, -1);  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法二  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH));  
	        // f.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法三(同一)  
	        cal.set(Calendar.DATE, 1);// 设为当前月的1号  
	        cal.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号  
	        cal.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天  
	        return DateFormatUtils.format(cal, DATE_FORMAT);  
	    }  
	  
	    /** 
	     * Title:getPreviousMonthFirst
	     * Description: 得到上个月的第一天
	     * @return String
	     */  
	    public static String getPreviousMonthFirst() {  
	        Calendar cal = Calendar.getInstance();  
	        Calendar f = (Calendar) cal.clone();  
	        f.clear();  
	        // 方法一  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);  
	        // f.set(Calendar.DATE, 1);  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法二  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);  
	        // f.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DATE));  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法三(同一)  
	        cal.set(Calendar.DATE, 1);// 设为当前月的1号  
	        cal.add(Calendar.MONTH, -1);  
	        return DateFormatUtils.format(cal, DATE_FORMAT);  
	    }  
	  
	    /** 
	     * Title:getPreviousMonthEnd
	     * Description: 得到上个月最后一天
	     * @return String
	     */  
	    public static String getPreviousMonthEnd() {  
	        Calendar cal = Calendar.getInstance();  
	        Calendar f = (Calendar) cal.clone();  
	        f.clear();  
	        // 方法一  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH));  
	        // f.set(Calendar.MILLISECOND, -1);  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法二  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);  
	        // f.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法三(同一)  
	        cal.set(Calendar.DATE, 1);// 设为当前月的1号  
	        cal.add(Calendar.MONTH, 0);//  
	        cal.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天  
	        return DateFormatUtils.format(cal, DATE_FORMAT);  
	    }  
	  
	    /** 
	     * Title:getNextMonthFirst
	     * Description: 得到下个月的第一天
	     * @return String
	     */  
	    public static String getNextMonthFirst() {  
	        Calendar cal = Calendar.getInstance();  
	        Calendar f = (Calendar) cal.clone();  
	        f.clear();  
	        // 方法一  
	        // f.set(Calendar.YEAR, cal.get(Calendar.YEAR));  
	        // f.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);  
	        // f.set(Calendar.DATE, 1);  
	        // or f.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DATE));  
	        // return DateFormatUtils.format(f, DATE_FORMAT);  
	  
	        // 方法二  
	        cal.set(Calendar.DATE, 1);// 设为当前月的1号  
	        cal.add(Calendar.MONTH, +1);// 加一个月，变为下月的1号  
	        return DateFormatUtils.format(cal, DATE_FORMAT);  
	    }  
	  
	    /** 
	     * Title:getNextMonthEnd
	     * Description: 得到下个月最后一天。
	     * @return String
	     */  
	    public static String getNextMonthEnd() {  
	        Calendar cal = Calendar.getInstance();  
	        // cal.set(Calendar.DATE, +1);  
	        // cal.add(Calendar.MONTH, +2);  
	        // cal.add(Calendar.DATE, -1);  
	        // return DateFormatUtils.format(cal, DATE_FORMAT);  
	  
	        // 方法二  
	        cal.add(Calendar.MONTH, 1);// 加一个月  
	        cal.set(Calendar.DATE, 1);// 把日期设置为当月第一天  
	        cal.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天  
	        return DateFormatUtils.format(cal, DATE_FORMAT);  
	    }  
	  
	    /** 
	     * Title:getCurrentMonthDays
	     * Description: 得到当前月的天数
	     * @return int
	     */  
	    public static int getCurrentMonthDays() {  
	        Calendar cal = new GregorianCalendar();// Calendar.getInstance();  
	        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
	        return days;  
	    }  
	  
	    /** 
	     * Title:getSpecifiedMonthDays
	     * Description: 得到指定的月份的天数
	     * @param date 
	     * @return int
	     */  
	    public static int getSpecifiedMonthDays(String date) {  
	        Calendar cal = Calendar.getInstance();  
	        try {  
	            cal.setTime(DateUtils.parseDate(date, MONTH_FORMAT));  
	            int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
	            return days;  
	        } catch (Exception e1) {  
	            e1.printStackTrace();  
	        }  
	        return 0;  
	    }  
	  
	    /** 
	     * Title:getCurrentMonth
	     * Description: 得到当前年月
	     * @return String
	     */  
	    public static String getCurrentMonth() {  
	        Calendar cal = Calendar.getInstance();  
	        String currentMonth = DateFormatUtils.format(cal, MONTH_FORMAT);  
	        return currentMonth;  
	    } 
	    /** 
	     * Title:getCurrentDay
	     * Description: 得到当前日期 yyyyMMdd
	     * @return String
	     */  
	    public static String getCurrentDay() {  
	        Calendar cal = Calendar.getInstance();  
	        String currentDate = DateFormatUtils.format(cal, DAY_FORMAT);  
	        return currentDate;  
	    }
	    /** 
	     * Title:getCurrentDate
	     * Description: 得到当前日期
	     * @return String
	     */  
	    public static String getCurrentDate() {  
	        Calendar cal = Calendar.getInstance();  
	        String currentDate = DateFormatUtils.format(cal, DATE_FORMAT);  
	        return currentDate;  
	    }  
	  
	    /** 
	     * Title:getCurrentTime
	     * Description: 得到当前的时间
	     * @return String
	     */  
	    public static String getCurrentTime() {  
	        Calendar cal = Calendar.getInstance();  
	        String currentDate = DateFormatUtils.format(cal, DATE_TIME_FORMAT);
	        return currentDate;  
	    }  
	  
	    /** 
	     * Title:getOffsetDate
	     * Description: 得到与当前日期偏移量为X的日期。
	     * @param offset 
	     * @return String
	     */  
	    public static String getOffsetDate(int offset) {  
	        Calendar cal = Calendar.getInstance();  
	        cal.add(Calendar.DAY_OF_MONTH, offset);  
	        String currentDate = DateFormatUtils.format(cal, DATE_FORMAT);  
	        return currentDate;  
	    }



	/**
	 * Title:getOffsetDate
	 * Description: 得到与当前日期偏移量为X的日期。
	 * @param offset
	 * @return String
	 */
	public static String getOffsetDateByFormat(int offset,String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, offset);
		String currentDate = DateFormatUtils.format(cal, format);
		return currentDate;
	}

	/**
	     * Title:getSpecifiedOffsetDate
	     * Description: 得到与指定日期偏移量为X的日期。
	     * @param specifiedDate 指定的日期
	     *            ,格式为YYYY-MM-DD 
	     * @param offset 
	     * @return 返回yyyy-MM-dd格式的字符串日期 String
	     * @throws ParseException
	     */  
	    public static String getSpecifiedOffset(String specifiedDate, int offset,String fmt){
			Date date = null;
			try {
				date = DateUtils.parseDate(specifiedDate, fmt);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar cal = DateUtils.toCalendar(date);
	        cal.add(Calendar.DAY_OF_MONTH, offset);  
	        String returnDate = DateFormatUtils.format(cal, fmt);
	        return returnDate;  
	    }

	    /**
	     * Title:getSpecifiedOffsetDate
	     * Description: 得到与指定日期偏移量为X的日期。
	     * @param specifiedDate 指定的日期
	     *            ,格式为YYYY-MM-DD
	     * @param offset
	     * @return 返回yyyy-MM-dd格式的字符串日期 String
	     * @throws ParseException
	     */
	    public static String getSpecifiedOffsetDate(String specifiedDate, int offset){
	        return getSpecifiedOffset(specifiedDate,offset, DATE_FORMAT);
	    }
	  
	    /** 
	     * Title:getSpecifiedOffsetTime
	     * Description: 得到与指定日期时间偏移量为X的时间。
	     * @param specifiedTime 
	     *            指定的时间,格式为yyyy-MM-dd HH:mm:ss 
	     * @param offset 
	     *            偏移天数 
	     * @return 返回yyyy-MM-dd HH:mm:ss格式的字符串时间 
	     * @throws ParseException 
	     * @return String 
	     */  
	    public static String getSpecifiedOffsetTime(String specifiedTime, int offset){
			return getSpecifiedOffset(specifiedTime,offset, DATE_TIME_FORMAT);
	    }
	  
	    /**
	     * Title:getOffsetDateTime
	     * Description: 得到与指定日期时间偏移量为X的时间。
	     * @param specifiedDateTime 
	     *            指定的时间,格式为yyyy-MM-dd HH:mm:ss/yyyy-MM-dd 
	     * @param offset 
	     *            偏移天数 
	     * @throws ParseException
	     * @return String 
	     */  
	    public static String getOffsetDateTime(String specifiedDateTime, int offset) throws ParseException {  
	        String regexStr = "\\d{4}-\\d{2}-\\d{2}";  
	        if (specifiedDateTime.matches(regexStr)) {  
	            return getSpecifiedOffsetDate(specifiedDateTime, offset);  
	        } else {  
	            return getSpecifiedOffsetTime(specifiedDateTime, offset);  
	        }  
	    }  
	  
	    /** 
	     * 判断是否为闰年
	     *  
	     * @param year 
	     * @return 
	     */  
	    public static boolean isLeapYear(int year) {  
	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);  
	    }  
	  
	    /** 
	     * 获取某年第一天日期 
	     * @param year 年份 
	     * @return Date 
	     */  
	    public static String getYearFirst(int year){  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.clear();  
	        calendar.set(Calendar.YEAR, year);  
	        String currYearFirst = DateFormatUtils.format(calendar, DATE_FORMAT);  
	        return currYearFirst;
	    } 
	    
	    /** 
	     * 获取今年第一天日期 
	     * @return Date
	     */  
	    public static String getCurrentYearFirst(){  
	    	Calendar currCal=Calendar.getInstance();    
	        int currentYear = currCal.get(Calendar.YEAR);  
	        return getYearFirst(currentYear);   
	    }
	    
	    /** 
	     * Title:getWeekDay
	     * Description: 判断是星期几.
	     * @param c 
	     * @return String
	     */  
	    public static String getWeekDay(Calendar c) {  
	        if (c == null) {  
	            return "星期一";  
	        }  
	        switch (c.get(Calendar.DAY_OF_WEEK)) {  
	        case Calendar.MONDAY:  
	            return "星期一";  
	        case Calendar.TUESDAY:  
	            return "星期二";  
	        case Calendar.WEDNESDAY:  
	            return "星期三";  
	        case Calendar.THURSDAY:  
	            return "星期四";  
	        case Calendar.FRIDAY:  
	            return "星期五";  
	        case Calendar.SATURDAY:  
	            return "星期六";  
	        default:  
	            return "星期日";  
	        }  
	    }  
	  
	    /**
	     * 获取某个月第一天是星期几
	     * @param date
	     * @return int
	     */
	    public static int getMonthFirstDaysWeekDay(String date) {  
	        Calendar cal = Calendar.getInstance();  
	        try {  
	            cal.setTime(DateUtils.parseDate(date, MONTH_FORMAT));  
	            return cal.get(Calendar.DAY_OF_WEEK);  
	        } catch (Exception e1) {  
	            e1.printStackTrace();  
	        }  
	        return 0;  
	    }  
	    
	    /**
	     * 获取本周第一天
	     * @return String
	     */
	    public static String getWeekStartDate(){
	    	Calendar cal = Calendar.getInstance();
	    	cal.setFirstDayOfWeek(Calendar.MONDAY);
//			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
//	    	cal.set(Calendar.HOUR_OF_DAY, 0);
//	    	cal.set(Calendar.MINUTE, 0);
//	    	cal.set(Calendar.SECOND, 0);
	    	String currentWeekFirstDate = DateFormatUtils.format(cal, DATE_FORMAT);  
	        return currentWeekFirstDate;
	    }

		/**
		 * 获取下周第一天
		 * @return
		 */
		public static String getNextWeekMonday() {
			return getSpecifiedOffsetDate(getWeekStartDate(),7);
		}
		/**
		 * 获取下周七天的日期
		 * @return
		 */
		public static String[] getNextWeek() {
			String weekStartDate = getWeekStartDate();
			String Mon = getSpecifiedOffsetDate(weekStartDate,7);
			String Tue = getSpecifiedOffsetDate(weekStartDate,8);
			String Wed = getSpecifiedOffsetDate(weekStartDate,9);
			String Thu = getSpecifiedOffsetDate(weekStartDate,10);
			String Fri = getSpecifiedOffsetDate(weekStartDate,11);
			String Sat = getSpecifiedOffsetDate(weekStartDate,12);
			String Sun = getSpecifiedOffsetDate(weekStartDate,13);
			String[] strings = {Mon,Tue,Wed,Thu,Fri,Sat,Sun};
			return strings;
		}
		/**
		 * 获取下周七天的日期-中文格式
		 * @return
		 */
		public static String[] getNextWeekCN() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			String currentWeekFirstDate = DateFormatUtils.format(cal, DATE_FORMAT_CN);

			String Mon = getSpecifiedOffset(currentWeekFirstDate,7,DATE_FORMAT_CN);
			String Tue = getSpecifiedOffset(currentWeekFirstDate,8,DATE_FORMAT_CN);
			String Wed = getSpecifiedOffset(currentWeekFirstDate,9,DATE_FORMAT_CN);
			String Thu = getSpecifiedOffset(currentWeekFirstDate,10,DATE_FORMAT_CN);
			String Fri = getSpecifiedOffset(currentWeekFirstDate,11,DATE_FORMAT_CN);
			String Sat = getSpecifiedOffset(currentWeekFirstDate,12,DATE_FORMAT_CN);
			String Sun = getSpecifiedOffset(currentWeekFirstDate,13,DATE_FORMAT_CN);
			String[] strings = {Mon,Tue,Wed,Thu,Fri,Sat,Sun};
			return strings;
		}

	/**
	     * Title:getDaysListBetweenDates
	     * Description: 获得两个日期之间的连续日期.
	     * @param begin 
	     *            开始日期 . 
	     * @param end 
	     *            结束日期 . 
	     * @return List<String>
	     */  
	    public static List<String> getDaysListBetweenDates(String begin, String end) {  
	        List<String> dateList = new ArrayList<String>();  
	        Date d1;  
	        Date d2;  
	        try {  
	            d1 = DateUtils.parseDate(begin, DATE_FORMAT);  
	            d2 = DateUtils.parseDate(end, DATE_FORMAT);  
	            if (d1.compareTo(d2) > 0) {  
	                return dateList;  
	            }  
	            do {  
	                dateList.add(DateFormatUtils.format(d1, DATE_FORMAT));  
	                d1 = DateUtils.addDays(d1, 1);  
	            } while (d1.compareTo(d2) <= 0);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        return dateList;  
	    }  
	  
	    /** 
	     * Title:getMonthsListBetweenDates
	     * Description: 获得连续的月份
	     * @param begin 
	     * @param end 
	     * @return List<String>
	     */
		public static List<String> getMonthsListBetweenDates(String begin, String end) {
	        List<String> dateList = new ArrayList<String>();  
	        Date d1;  
	        Date d2;  
	        try {  
	            d1 = DateUtils.parseDate(begin, DATE_FORMAT);  
	            d2 = DateUtils.parseDate(end, DATE_FORMAT);  
	            if (d1.compareTo(d2) > 0) {  
	                return dateList;  
	            }  
	            do {  
	                dateList.add(DateFormatUtils.format(d1, MONTH_FORMAT));  
	                d1 = DateUtils.addMonths(d1, 1);  
	            } while (d1.compareTo(d2) <= 0);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        return dateList;  
	    }  
	    
	    /**
	     * 指定年月的第N周的第一天，即星期一
	     * @param year
	     * @param month
	     * @param weekOrder
	     * @return String
	     */
	    public static String getFirstDayOfWeekOrder(int year, int month, int weekOrder){  
	 	   
		     final Calendar c = Calendar.getInstance();  
		     c.set(Calendar.YEAR, year);  
		     c.set(Calendar.MONTH, month - 1);  
		     c.set(Calendar.DAY_OF_MONTH, 1); // 设为每个月的第一天(1号)  
		   
		     int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 每个月的第一天为星期几  
		   
		     /* 
		      * 星期日:1,星期一:2,星期二:3,星期三:4,星期四:5,星期五:6,星期六:7 
		      * 转化为我们的使用习惯:星期一:1,星期二:2,星期三:3,星期四:4,星期五:5,星期六:6,星期日:7 
		      */  
		     if (dayOfWeek != Calendar.SUNDAY)  
		     {  
		         dayOfWeek = dayOfWeek - 1;  
		     }  
		     else  
		     {  
		         dayOfWeek = 7;  
		     }  
		     c.add(Calendar.DAY_OF_MONTH, 1 - dayOfWeek); // 使其为每个月第一天所在周的星期一  
		     c.add(Calendar.DAY_OF_MONTH, (weekOrder - 1) * 7);  
		     
			    String result = DateFormatUtils.format(c.getTime(),DATE_FORMAT);
			    String monthstr = month+"";
			    if(month < 10 ){
			    	monthstr = "0"+month;
			    }
			    String monthFirstDay = getSpecifiedMonthFirstDay(year+"-"+monthstr);
			    if(!result.split("-")[1].equalsIgnoreCase(monthFirstDay.split("-")[1])){
			    	result = monthFirstDay;
			    }
			    System.out.println(result);
			    return result; 
		 } 
	    /**
	     * 指定年月的第N周的星期天
	     * @param year
	     * @param month
	     * @param weekOrder
	     * @return String
	     */
		 public static String getLastDayOfWeekOrder(int year, int month, int weekOrder)  
		 { 
		 final Calendar c = Calendar.getInstance();  
		    c.set(Calendar.YEAR, year);  
		    c.set(Calendar.MONTH, month - 1);  
		    c.set(Calendar.DAY_OF_MONTH, 1); // 设为每个月的第一天(1号)  
		  
		    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 每个月的第一天为星期几  
		  
		    /* 
		     * 星期日:1,星期一:2,星期二:3,星期三:4,星期四:5,星期五:6,星期六:7 
		     * 转化为我们的使用习惯:星期一:1,星期二:2,星期三:3,星期四:4,星期五:5,星期六:6,星期日:7 
		     */  
		    if (dayOfWeek != Calendar.SUNDAY)  
		    {  
		        dayOfWeek = dayOfWeek - 1;  
		    }  
		    else  
		    {  
		        dayOfWeek = 7;  
		    }  
		    c.add(Calendar.DAY_OF_MONTH, 1 - dayOfWeek); // 使其为每个月第一天所在周的星期一  
		    c.add(Calendar.DAY_OF_MONTH, (weekOrder - 1) * 7 + 6); 
		    String result = DateFormatUtils.format(c.getTime(),DATE_FORMAT);
		    String monthstr = month+"";
		    if(month < 10 ){
		    	monthstr = "0"+month;
		    }
		    String monthLastDay = getSpecifiedMonthLastDay(year+"-"+monthstr);
		    if(!result.split("-")[1].equalsIgnoreCase(monthLastDay.split("-")[1])){
		    	result = monthLastDay;
		    }
		    System.out.println(result);
		    return result; 
		}
		 public static int getMonthWeek (String date){   
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
			    int monthweekcount = 0;
			    Date s;
				try {
					s = sdf.parse(date);
				    Calendar ca = Calendar.getInstance();  
				    ca.setTime(s);  
				    ca.setFirstDayOfWeek(Calendar.MONDAY);  
				    monthweekcount = ca.getActualMaximum(Calendar.WEEK_OF_MONTH);
				} catch (ParseException e) {
					e.printStackTrace();
				}    
				return monthweekcount;
		 }
	    /** 
	     * Title:long2Time
	     * Description: 将long类型的时间值转换成标准格式的时间
	     * @param createTime 
	     * @return String
	     */  
	    public static String long2Time(String createTime,String fmt) {
	        long fooTime = Long.parseLong(createTime) * 1000L;  
	        return DateFormatUtils.format(fooTime, fmt);
	    }
	    /**
	     * Title:long2Time
	     * Description: 将long类型的时间值转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
	     * @param createTime
	     * @return String
	     */
	    public static String long2Time(String createTime) {
	        return long2Time(createTime, DATE_TIME_FORMAT);
	    }

	/**
	 * 时间相减
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static long datesDiff(Date dateStart,Date dateEnd) {
		return dateEnd.getTime() - dateStart.getTime();
	}
	/**
	 * 时间相隔的秒数
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static long datesDiffSecond(Date dateStart,Date dateEnd) {
		return (dateEnd.getTime() - dateStart.getTime())/1000;
	}
	/**
	 * 时间相隔的分钟数
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static long datesDiffMinute(Date dateStart,Date dateEnd) {
		return (dateEnd.getTime() - dateStart.getTime())/1000/60;
	}
	/**
	 * 时间相隔的小时数
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static long datesDiffHour(Date dateStart,Date dateEnd) {
		return (dateEnd.getTime() - dateStart.getTime())/1000/60/60;
	}

		public static void main(String[] args) throws ParseException {
//	        System.out.println(getMonthFirstDay());  
//	        System.out.println(getMonthLastDay());  
//	        System.out.println(getPreviousMonthFirst());  
//	        System.out.println(getPreviousMonthEnd());  
//	        System.out.println(getNextMonthFirst());  
//	        System.out.println(getNextMonthEnd());  
//	        System.out.println(getCurrentMonthDays());  
//	        System.out.println(getSpecifiedMonthDays("1900-02"));  
//	        System.out.println(getCurrentDate());  
//	        System.out.println(getOffsetDate(-4));  
//	        System.out.println(isLeapYear(1900));  
//	        System.out.println(getWeekDay(Calendar.getInstance()));  
//	        System.out.println(getDaysListBetweenDates("2012-1-12", "2012-1-21"));  
//	        System.out.println(getMonthsListBetweenDates("2012-1-12", "2012-3-21"));  
//	        System.out.println(getSpecifiedOffsetTime("2012-09-09 12:12:12", 12));  
//	        System.out.println(getOffsetDateTime("2012-09-09", 12));  
//	        System.out.println(getOffsetDateTime("2012-09-09 12:12:12", 12));  
//	        System.out.println(long2Time("1234567890"));  
//	        System.out.println(getSpecifiedMonthFirstDay("2017-02"));
//	        System.out.println(getSpecifiedMonthLastDay("2017-02"));
	    	
	        int count = getMonthWeek("2017-06");
			 for(int i=1;i<=count;i++){
				 getFirstDayOfWeekOrder(2017, 6, i);
				 getLastDayOfWeekOrder(2017, 6, i);
			 }
//			 getLastDayOfWeekOrder(2017, 6, 5);
	    }  
}
