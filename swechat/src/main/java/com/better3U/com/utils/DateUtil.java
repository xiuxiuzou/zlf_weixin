package com.better3U.com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtil {
    /**
     * 获取某段时间内的所有日期String格式
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<String> findDates(String dBegin, String dEnd) {
        List<Date> lDate = findDates(DateUtil.parseDate(dBegin, "yyyy-MM-dd"), DateUtil.parseDate(dEnd, "yyyy-MM-dd"));
        List<String> ls = new ArrayList<String>();
        for(Date dates : lDate){
            ls.add(DateUtil.getDateFormate(dates,"yyyy-MM-dd"));
        }
        return ls;
    }
    
	/**
	 * <ul>
	 * <li>Description:[获取某段时间内的所有日期]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @return true or false
	 */
	public static List<Date> findDates(Date dBegin, Date dEnd) {
		List<Date> lDate = new ArrayList<Date>();
		// lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			lDate.add(calBegin.getTime());
			// System.out.println(calBegin.getTime());
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
		}

		lDate.add(calBegin.getTime());
		return lDate;
	}

	/**
	 * <ul>
	 * <li>Description:[判断两个日期是否是同一天]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @return true or false
	 */
	public static boolean isSameDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth
				&& cal1.get(Calendar.DAY_OF_MONTH) == cal2
						.get(Calendar.DAY_OF_MONTH);

		return isSameDate;
	}

	/**
	 * <ul>
	 * <li>Description:[得到当前的时间]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @return
	 */
	public static Date getDate() {
		Calendar canlendar = Calendar.getInstance();
		return canlendar.getTime();
	}

	/**
	 * <ul>
	 * <li>Description:[提到指定的millis得到时间]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param millis
	 * @return
	 */
	public static Date getDate(long millis) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.setTimeInMillis(millis);
		return canlendar.getTime();
	}

	public static long getMillis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * <ul>
	 * <li>Description:[得到指定日期的字符串(yyyy-MM-dd HH:mm:ss.SSS)]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @param formate
	 * @return
	 */
	public static String getDateFormate(Date date, String formate) {
		try {
			SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
			return simpleDateFormate.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到HHMM格式字符串]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String getHHmm(Date date) {
		return DateUtil.getDateFormate(date, "HHmm");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到MMDD格式字符串]</li>
	 * <li>Created by [Liangdong] [JUN12, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String getMd(Date date) {
		return DateUtil.getDateFormate(date, "MMdd");
	}
	/**
	 * <ul>
	 * <li>Description:[根据日期得到MM月份字符串]</li>
	 * <li>Created by [Liangdong] [JUN 12, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String getMM(Date date) {
		return DateUtil.getDateFormate(date, "MM");
	}
	public static String getDD(Date date) {
		return DateUtil.getDateFormate(date, "dd");
	}
	public static String getYYYY(Date date) {
		return DateUtil.getDateFormate(date, "yyyy");
	}
	public static String getHH(Date date) {
		return DateUtil.getDateFormate(date, "HH");
	}
	/**
	 * <ul>
	 * <li>Description:[根据日期得到mm分钟字符串]</li>
	 * <li>Created by [Liangdong] [DEC 12, 2016]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String getmm(Date date) {
		return DateUtil.getDateFormate(date, "mm");
	}
	public static String getss(Date date) {
		return DateUtil.getDateFormate(date, "ss");
	}
	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD HH:MM:SS.SSS格式字符串]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMdHmsS(Date date) {
		return DateUtil.getDateFormate(date, "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD HH:MM:SS格式字符串]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMdHms(Date date) {
		return DateUtil.getDateFormate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYYMMDDHHMMSS格式字符串]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [Liangdong] [OCT 26, 2016]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMdHmsWithoutLine(Date date) {
		return DateUtil.getDateFormate(date, "yyyyMMddHHmmss");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD HH:MM格式字符串]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMdHm(Date date) {
		return DateUtil.getDateFormate(date, "yyyy-MM-dd HH:mm");
	}

	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYY-MM-DD格式字符串]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yMd(Date date) {
		return DateUtil.getDateFormate(date, "yyyy-MM-dd");
	}
	public static String get4yM(Date date) {
		return DateUtil.getDateFormate(date, "yyyy-MM");
	}
	/**
	 * <ul>
	 * <li>Description:[根据日期得到YYYYMMDD格式字符串]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String get4yyyyMMdd(Date date) {
		return DateUtil.getDateFormate(date, "yyyyMMdd");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd HH:mm:ss.SSS)串转成Date]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMdHmsS(String sDate) {
		return DateUtil.parseDate(sDate, "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd HH:mm:ss)串转成Date]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMdHms(String sDate) {
		return DateUtil.parseDate(sDate, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd HH:mm)串转成Date]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMdHm(String sDate) {
		return DateUtil.parseDate(sDate, "yyyy-MM-dd HH:mm");
	}

	/**
	 * <ul>
	 * <li>Description:[获取一段时间有多少周]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 *            eDate 开始日期 结束日期
	 * @return
	 */
	public static int getDatesBetweenWeeks(Date sdate, Date edate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(sdate);
		int begin = calendar.get(Calendar.WEEK_OF_YEAR);
		calendar.setTime(edate);
		int end = calendar.get(Calendar.WEEK_OF_YEAR);
		return end - begin;
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyy-MM-dd)串转成Date]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMd(String sDate) {
		return DateUtil.parseDate(sDate, "yyyy-MM-dd");
	}
	public static Date parse4yM(String sDate) {
		return DateUtil.parseDate(sDate, "yyyy-MM");
	}
	/**
	 * <ul>
	 * <li>Description:[把指定字符(HHmm)串转成Date]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yHHmm(String sDate) {
		return DateUtil.parseDate(sDate, "HHmm");
	}

	/**
	 * <ul>
	 * <li>Description:[把指定字符(yyyyMMdd)串转成Date]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parse4yMdWithoutLine(String sDate) {
		return DateUtil.parseDate(sDate, "yyyyMMdd");
	}

	/**
	 * <ul>
	 * <li>Description:[根据指定格式,把字符串转成日期]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 * @param formate
	 * @return
	 */
	public static Date parseDate(String sDate, String formate) {
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
		try {
			return simpleDateFormate.parse(sDate);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * <ul>
	 * <li>Description:[两个长整型的时间相差(时间的毫秒数),可以得到指定的毫秒数,秒数,分钟数,天数]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param minuendTime
	 *            [被减去的时间]
	 * @param subtrahendTime
	 *            [减去的时间]
	 * @param tdatestr
	 *            [part可选值["D","H","M","S","MS"]
	 * @return[minuendTime-subtrahendTime]
	 * @return
	 */
	public static double getDifTwoTime(Date minuendTime, Date subtrahendTime,
			String tdatestr) {
		if (minuendTime == null || subtrahendTime != null) {
			return DateUtil.getDifTwoTime(minuendTime.getTime(),
					subtrahendTime.getTime(), tdatestr);
		}
		return 0;
	}

	/**
	 * <ul>
	 * <li>Description:[两个长整型的时间相差(时间的毫秒数),可以得到指定的毫秒数,秒数,分钟数,天数]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param minuendTime
	 *            [被减去的时间]
	 * @param subtrahendTime
	 *            [减去的时间]
	 * @param tdatestr
	 *            [part可选值["D","H","M","S","MS"]
	 * @return[minuendTime-subtrahendTime]
	 */
	public static double getDifTwoTime(long minuendTime, long subtrahendTime,
			String tdatestr) {
		if (tdatestr == null || tdatestr.equals("")) {
			tdatestr = "MS";
		}
		double temp = 1;
		/** 毫秒数 */
		if ("MS".equalsIgnoreCase(tdatestr)) {
			temp = 1;
		}
		/** 得到秒 */
		if ("S".equalsIgnoreCase(tdatestr)) {
			temp = 1000;
		}
		/** 得到分 */
		if ("M".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60;
		}
		/** 得到小时 */
		if ("H".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60 * 60;
		}
		/** 得到天 */
		if ("D".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60 * 60 * 24;
		}
		return (minuendTime - subtrahendTime) / temp;
	}

	/**
	 * <ul>
	 * <li>Description:[从日期中得到指定部分(YYYY/MM/DD/HH/SS/SSS)数字]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date
	 * @param part
	 *            [part可选值["Y","M","D","H","M","S","MS"]
	 * @return
	 */
	public static int getPartOfTime(Date date, String part) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.setTime(date);
		/** 得到年 */
		if (part.equalsIgnoreCase("Y")) {
			return canlendar.get(Calendar.YEAR);
		}
		/** 得到月 */
		if (part.equalsIgnoreCase("M")) {
			return canlendar.get(Calendar.MONTH) + 1;
		}
		/** 得到日 */
		if (part.equalsIgnoreCase("D")) {
			return canlendar.get(Calendar.DAY_OF_MONTH);
		}
		/** 得到时 */
		if (part.equalsIgnoreCase("H")) {
			return canlendar.get(Calendar.HOUR_OF_DAY);
		}
		/** 得到分 */
		if (part.equalsIgnoreCase("M")) {
			return canlendar.get(Calendar.MINUTE);
		}
		/** 得到秒 */
		if (part.equalsIgnoreCase("S")) {
			return canlendar.get(Calendar.SECOND);
		}
		/** 得到毫秒 */
		if (part.equalsIgnoreCase("MS")) {
			return canlendar.get(Calendar.MILLISECOND);
		}
		return -1;
	}
	/**
	 * <ul>
	 * <li>Description:[输入几小时几分钟1:60 输出分钟]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param mins
	 *            总的分钟数
	 * @return X小时Y分钟
	 */
	
	/**
	 * <ul>
	 * <li>Description:[输入分钟 输出几小时几分钟]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param mins
	 *            总的分钟数
	 * @return X小时Y分钟
	 */
	public static String mins2HourAndMin(Integer mins) {
		if (mins > 0)
			return (mins / 60) + "小时" + (mins % 60);
		else
			return "-" + (-mins / 60) + "小时" + (-mins % 60);
	}
	
	public static String mins2HourAndMin(Integer mins,String punctuation) {
		if(punctuation==null){
			return mins2HourAndMin(mins);
		}else{
			if (mins > 0)
				return ((mins / 60)<10?"0"+  (mins / 60): (mins / 60) )+ punctuation + ((mins % 60)<10?"0"+(mins % 60):(mins % 60));
			else
				return "-" + (-mins / 60) + punctuation+ (-mins % 60);
		}
	}

	/**
	 * <ul>
	 * <li>Description:[输入要增加或者减少的日期]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date1
	 *            输入要增加或者减少的日期 x表示增加或者减少的分钟
	 * @return 增加或者减少后的时间
	 */
	public static Date addDateMinut(Date date1, int x) {
		Calendar cal = Calendar.getInstance();
		Date date = null;
		date = date1;
		cal.setTime(date);
		cal.add(Calendar.MINUTE, x);// 24小时制
		date = cal.getTime();
		cal = null;
		return date;
	}

	/**
	 * <ul>
	 * <li>Description:[获取日期是星期几]</li>
	 * <li>Created by [Liangdong] [DEC 26, 2015]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param date1
	 *            输入要增加或者减少的日期 x表示增加或者减少的分钟
	 * @return 获取日期是星期几
	 */
	public static int getWeekOfDate(Date date) {
		int[] weekOfDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekOfDays[w];
	}

	/**
	 * <ul>
	 * <li>Description:[根据输入的年月得到当月第一个周几是几号]</li>
	 * <li>Created by [Liangdong] [MAR 31, 2016]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param int year, int month 输入年和月
	 * @return 当月第一个周一是几号 第二个周几时几号
	 */
	public static int getDay(int year, int month, int week) {
		int j = week + 1;
		// 由于星期天排在第一，所以需要特殊处理
		if (week == 7) {
			j = 1;
		}
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		// 14天内,必然出现星期一到星期天
		for (int i = 1; i < 15; i++) {
			cal.set(Calendar.DAY_OF_MONTH, i);
			if (cal.get(Calendar.DAY_OF_WEEK) == j) {
				return cal.get(Calendar.DAY_OF_MONTH);
			}
		}
		return 99;
	}

	/**
	 * <ul>
	 * <li>Description:[根据输入的日月年得到YYYY-MM-DD格式的年月日字符串]</li>
	 * <li>Created by [Liangdong] [NOV 02, 2016]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param String
	 *            dayMonth(en)year 01OCT16 or 01OCT2016 输入日月(en)年
	 * @return YYYY-MM-DD格式 2016-10-01
	 */
	public static String parseDD_MMEN_YY(String thisDate) {

		if (thisDate == null || thisDate.length() < 7 || thisDate.length() > 9
				|| thisDate.length() == 8) {
			return null;
		}
		String dd = thisDate.substring(0, 2);
		String mmen = thisDate.substring(2, 5);
		String yy_yyyy = thisDate.substring(5, thisDate.length());
		if (thisDate.length() < 8) {
			yy_yyyy = "20" + yy_yyyy;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("JAN", "01");
		map.put("FEB", "02");
		map.put("MAR", "03");
		map.put("APR", "04");
		map.put("MAY", "05");
		map.put("JUN", "06");
		map.put("JUL", "07");
		map.put("AUG", "08");
		map.put("SEP", "09");
		map.put("OCT", "10");
		map.put("NOV", "11");
		map.put("DEC", "12");
		mmen = map.get(mmen);
		String yyyy_mm_dd = yy_yyyy + "-" + mmen + "-" + dd;
		return yyyy_mm_dd;
	}

	/**
	 * <ul>
	 * <li>Description:[获取增加或者减少分钟数后的日期]</li>
	 * <li>Created by [Liangdong] [NOV 25, 2016]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param String
	 *            day, int minutes 输入的是String day日期, int minutes 增加或者减少的分钟数
	 * @return 返回的是变化后的字符串型的时间
	 */
	public static String addDateMinut(String day, int minutes) {
		if (day.length() < 11) {
			day = day + " 00:00:00";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
		// 引号里面个格式也可以是 HH:mm:ss或者HH:mm等等，很随意的，不过在主函数调用时，要和输入的变
		// 量day格式一致
		Date date = null;
		try {
			date = format.parse(day);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (date == null)
			return "";
		// System.out.println("front:" + format.format(date)); // 显示输入的日期
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);// 24小时制
		date = cal.getTime();
		System.out.println("after:" + format.format(date)); // 显示更新后的日期
		cal = null;
		return format.format(date);

	}

	/**
	 * <ul>
	 * <li>Description:[传入时间是否在一段时间内]</li>
	 * <li>Created by [Liangdong] [DEC 01, 2016]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param sDate
	 *            开始时间 eDate 结束时间 nowTime 传入需要判断的时间
	 * @return
	 */
	public static boolean isTimeInTimes(Date stime, Date etime, Date nowTime) {
		return (nowTime.equals(stime) || nowTime.after(stime))
				&& (nowTime.equals(etime) || nowTime.before(etime));
	}

	// public static int theFirstWeek(int year, int month, int week){
	//
	// }
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 默认时间格式
	private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.SHORT_DATE_PATTERN_LINE.formatter;

	// 无参数的构造函数,防止被实例化
	// private DateUtil() {};

	/**
	 * 
	 * <ul>
	 * <li>Description:[String 转化为 LocalDateTime ]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * String 转化为 LocalDateTime
	 * 
	 * @param timeStr
	 *            被转化的字符串
	 * @return LocalDateTime
	 */
	public static LocalDateTime parseTime(String timeStr) {
		return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);

	}

	/**
	 * <ul>
	 * <li>Description:[String 转化为 LocalDateTime ]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * String 转化为 LocalDateTime
	 * 
	 * @param timeStr
	 *            被转化的字符串
	 * @param timeFormat
	 *            转化的时间格式
	 * @return LocalDateTime
	 */
	public static LocalDateTime parseTime(String timeStr, TimeFormat timeFormat) {
		return LocalDateTime.parse(timeStr, timeFormat.formatter);

	}

	/**
	 * <ul>
	 * <li>Description:[LocalDateTime 转化为String ]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * LocalDateTime 转化为String
	 * 
	 * @param time
	 *            LocalDateTime
	 * @return String
	 */
	public static String parseTime(LocalDateTime time) {
		return DEFAULT_DATETIME_FORMATTER.format(time);

	}

	/**
	 * <ul>
	 * <li>Description:[LocalDateTime 时间转 String ]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * LocalDateTime 时间转 String
	 * 
	 * @param time
	 *            LocalDateTime
	 * @param format
	 *            时间格式
	 * @return String
	 */
	public static String parseTime(LocalDateTime time, TimeFormat format) {
		return format.formatter.format(time);

	}

	/**
	 * <ul>
	 * <li>Description:[获取当前时间 ]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
	}

	/**
	 * <ul>
	 * <li>Description:[获取当前时间 ]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 获取当前时间
	 * 
	 * @param timeFormat
	 *            时间格式
	 * @return
	 */
	public static String getCurrentDateTime(TimeFormat timeFormat) {
		return timeFormat.formatter.format(LocalDateTime.now());
	}

	/**
	 * <ul>
	 * <li>Description:[获取当前时间 ]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 获取当前时间
	 * 
	 * @param timeFormat
	 *            时间格式
	 * @return
	 */
	public static String getNeedFormatDateTime(LocalDateTime localDateTime,
			TimeFormat timeFormat) {
		return timeFormat.formatter.format(localDateTime);
	}

	/**
	 * <ul>
	 * <li>Description:[内部枚举类 时间格式化]</li>
	 * <li>Created by [Liangdong] [APRIL 20, 2017]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 内部枚举类
	 * 
	 * @author liangdong
	 * @date 2017年4月19日 @ version 1.0
	 */
	public enum TimeFormat {
		// 短时间格式 年月日
		/**
		 * 时间格式：yyyy-MM-dd
		 */
		SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
		/**
		 * 时间格式：yyyy/MM/dd
		 */
		SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
		/**
		 * 时间格式：yyyy\\MM\\dd
		 */
		SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
		/**
		 * 时间格式：yyyyMMdd
		 */
		SHORT_DATE_PATTERN_NONE("yyyyMMdd"),

		// 长时间格式 年月日时分秒
		/**
		 * 时间格式：yyyy-MM-dd HH:mm:ss
		 */
		LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),

		/**
		 * 时间格式：yyyy/MM/dd HH:mm:ss
		 */
		LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
		/**
		 * 时间格式：yyyy\\MM\\dd HH:mm:ss
		 */
		LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
		/**
		 * 时间格式：yyyyMMdd HH:mm:ss
		 */
		LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),

		// 长时间格式 年月日时分秒 带毫秒
		LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),

		LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),

		LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),

		LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");

		private transient DateTimeFormatter formatter;

		TimeFormat(String pattern) {
			formatter = DateTimeFormatter.ofPattern(pattern);

		}
	}

	public static void main(String[] args) {
		/*Date date = new Date();
		System.out.println(date);
		Date ddd = addDateMinut(date, -100);
		System.out.println(ddd);
		int year = 2016;
		int month = 4;
		for (int i = 1; i <= 7; i++) {
			System.out.println("第一个星期" + i + "的号数是：" + getDay(year, month, i));
		}*/
	    findDates("2017-11-30","2017-12-2").forEach(System.out::println);
	}
}