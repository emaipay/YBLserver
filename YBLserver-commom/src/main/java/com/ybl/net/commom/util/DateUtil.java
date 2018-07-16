package com.ybl.net.commom.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期类型与字符串类型相互转换
 */
public class DateUtil {

	/**
	 * Base ISO 8601 Date format yyyyMMdd i.e., 20021225 for the 25th day of
	 * December in the year 2002
	 */
	public static final String ISO_DATE_FORMAT = "yyyyMMdd";

	public static final String ISO_DATE_FORMAT_MIN = "yyyyMMddHHmm";

	/**
	 * Expanded ISO 8601 Date format yyyy-MM-dd i.e., 2002-12-25 for the 25th
	 * day of December in the year 2002
	 */
	public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy/MM/dd";

	/**
	 * yyyy-MM-dd hh:mm:ss
	 */
	public static String DATETIME_PATTERN = "yyyy/MM/dd HH:mm:ss";

	public static String DATETIME_PATTERN_MIN = "yyyy/MM/dd HH:mm";

	public static String DATETIME_PATTERN_MIL = "yyyy/MM/dd HH:mm:ss:SSS";

	// yyyyMMddHHmmss
	public static String DATETIME_PATTERN2 = "yyyyMMddHHmmss";

	public static String DATETIME_PATTERN2_MIL = "yyyyMMddHHmmssSSS";

	/**
	 * Default lenient setting for getDate.
	 */
	private static boolean LENIENT_DATE = false;

	/**
	 * 暂时不用
	 * 
	 * @param JD
	 * @return
	 */
	protected static final float normalizedJulian(float JD) {

		float f = Math.round(JD + 0.5f) - 0.5f;

		return f;
	}

	/**
	 * 浮点值转换成日期格式<br>
	 * 暂时不用 Returns the Date from a julian. The Julian date will be converted to
	 * noon GMT, such that it matches the nearest half-integer (i.e., a julian
	 * date of 1.4 gets changed to 1.5, and 0.9 gets changed to 0.5.)
	 *
	 * @param JD
	 *            the Julian date
	 * @return the Gregorian date
	 */
	public static final Date toDate(float JD) {

		/*
		 * To convert a Julian Day Number to a Gregorian date, assume that it is
		 * for 0 hours, Greenwich time (so that it ends in 0.5). Do the
		 * following calculations, again dropping the fractional part of all
		 * multiplicatons and divisions. Note: This method will not give dates
		 * accurately on the Gregorian Proleptic Calendar, i.e., the calendar
		 * you get by extending the Gregorian calendar backwards to years
		 * earlier than 1582. using the Gregorian leap year rules. In
		 * particular, the method fails if Y<400.
		 */
		float Z = (normalizedJulian(JD)) + 0.5f;
		float W = (int) ((Z - 1867216.25f) / 36524.25f);
		float X = (int) (W / 4f);
		float A = Z + 1 + W - X;
		float B = A + 1524;
		float C = (int) ((B - 122.1) / 365.25);
		float D = (int) (365.25f * C);
		float E = (int) ((B - D) / 30.6001);
		float F = (int) (30.6001f * E);
		int day = (int) (B - D - F);
		int month = (int) (E - 1);

		if (month > 12) {
			month = month - 12;
		}

		int year = (int) (C - 4715); // (if Month is January or February) or
										// C-4716 (otherwise)

		if (month > 2) {
			year--;
		}

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1); // damn 0 offsets
		c.set(Calendar.DATE, day);

		return c.getTime();
	}

	/**
	 * Returns the days between two dates. Positive values indicate that the
	 * second date is after the first, and negative values indicate, well, the
	 * opposite. Relying on specific times is problematic.
	 *
	 * @param early
	 *            the "first date"
	 * @param late
	 *            the "second date"
	 * @return the days between the two dates
	 */
	public static final int daysBetween(Date early, Date late) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(early);
		c2.setTime(late);

		return daysBetween(c1, c2);
	}

	/**
	 * Returns the days between two dates. Positive values indicate that the
	 * second date is after the first, and negative values indicate, well, the
	 * opposite.
	 *
	 * @param early
	 * @param late
	 * @return the days between two dates.
	 */
	public static final int daysBetween(Calendar early, Calendar late) {

		return (int) (toJulian(late) - toJulian(early));
	}

	/**
	 * Return a Julian date based on the input parameter. This is based from
	 * calculations found at <a
	 * href="http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html">Julian Day
	 * Calculations (Gregorian Calendar)</a>, provided by Bill Jeffrys.
	 * 
	 * @param c
	 *            a calendar instance
	 * @return the julian day number
	 */
	public static final float toJulian(Calendar c) {

		int Y = c.get(Calendar.YEAR);
		int M = c.get(Calendar.MONTH);
		int D = c.get(Calendar.DATE);
		int A = Y / 100;
		int B = A / 4;
		int C = 2 - A + B;
		float E = (int) (365.25f * (Y + 4716));
		float F = (int) (30.6001f * (M + 1));
		float JD = C + D + E + F - 1524.5f;

		return JD;
	}

	/**
	 * 暂时不用 Return a Julian date based on the input parameter. This is based
	 * from calculations found at <a
	 * href="http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html">Julian Day
	 * Calculations (Gregorian Calendar)</a>, provided by Bill Jeffrys.
	 * 
	 * @param date
	 * @return the julian day number
	 */
	public static final float toJulian(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		return toJulian(c);
	}

	/**
	 * 日期增加
	 * 
	 * @param isoString
	 *            日期字符�?
	 * @param fmt
	 *            格式
	 * @param field
	 *            �?�?�?Calendar.YEAR/Calendar.MONTH/Calendar.DATE
	 * @param amount
	 *            增加数量
	 * @return
	 * @throws ParseException
	 */
	public static final String dateIncrease(String isoString, String fmt,
			int field, int amount) {

		try {
			Calendar cal = GregorianCalendar.getInstance(TimeZone
					.getTimeZone("GMT"));
			cal.setTime(stringToDate(isoString, fmt, true));
			cal.add(field, amount);

			return dateToString(cal.getTime(), fmt);

		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Time Field Rolling function. Rolls (up/down) a single unit of time on the
	 * given time field.
	 *
	 * @param isoString
	 * @param field
	 *            the time field.
	 * @param up
	 *            Indicates if rolling up or rolling down the field value.
	 * @param expanded
	 *            use formating char's
	 * @exception ParseException
	 *                if an unknown field value is given.
	 */
	public static final String roll(String isoString, String fmt, int field,
			boolean up) throws ParseException {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(stringToDate(isoString, fmt));
		cal.roll(field, up);

		return dateToString(cal.getTime(), fmt);
	}

	/**
	 * Time Field Rolling function. Rolls (up/down) a single unit of time on the
	 * given time field.
	 *
	 * @param isoString
	 * @param field
	 *            the time field.
	 * @param up
	 *            Indicates if rolling up or rolling down the field value.
	 * @exception ParseException
	 *                if an unknown field value is given.
	 */
	public static final String roll(String isoString, int field, boolean up)
			throws ParseException {

		return roll(isoString, DATETIME_PATTERN, field, up);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符
	 * @param format
	 *            日期格式
	 * @param lenient
	 *            日期越界标志
	 * @return
	 */
	public static Date stringToDate(String dateText, String format,
			boolean lenient) {

		if (dateText == null) {

			return null;
		}

		DateFormat df = null;

		try {

			if (format == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(format);
			}

			// setLenient avoids allowing dates like 9/32/2001
			// which would otherwise parse to 10/2/2001
			df.setLenient(false);

			return df.parse(dateText);
		} catch (ParseException e) {

			return null;
		}
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date stringToDate(String dateString, String format) {

		return stringToDate(dateString, format, LENIENT_DATE);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符
	 */
	public static Date stringToDate(String dateString) {

		return stringToDate(dateString, ISO_EXPANDED_DATE_FORMAT, LENIENT_DATE);
	}

	/**
	 * 根据时间变量返回时间字符
	 * 
	 * @return 返回时间字符
	 * @param pattern
	 *            时间字符串样
	 * @param date
	 *            时间变量
	 */
	public static String dateToString(Date date, String pattern) {

		if (date == null) {

			return null;
		}

		try {

			SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
			// sfDate.setLenient(false);

			return sfDate.format(date);
		} catch (Exception e) {

			return null;
		}
	}

	/**
	 * 根据时间变量返回时间字符yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, ISO_EXPANDED_DATE_FORMAT);
	}

	/**
	 * 返回当前时间
	 * 
	 * @return 返回当前时间
	 */
	public static Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();

		return dtNow;
	}

	/**
	 * 返回当前日期字符
	 * 
	 * @param pattern
	 *            日期字符串样
	 * @return
	 */
	public static String getCurrentDateString(String pattern) {
		return dateToString(getCurrentDateTime(), pattern);
	}

	/**
	 * 返回当前日期字符yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {
		return dateToString(getCurrentDateTime(), ISO_EXPANDED_DATE_FORMAT);
	}

	/**
	 * 返回当前日期+时间字符yyyy-MM-dd hh:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStringWithTime(Date date) {

		return dateToString(date, DATETIME_PATTERN);
	}

	/**
	 * 返回当前日期+时间字符yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStringWithDay(Date date) {

		return dateToString(date, ISO_DATE_FORMAT);
	}

	/**
	 * 日期增加-按分钟增加
	 * 
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByMinute(Date date, int minutes) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);

		return cal.getTime();
	}

	/**
	 * 日期增加-按小时增加
	 * 
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByHour(Date date, int hours) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);

		return cal.getTime();
	}

	/**
	 * 日期增加-按日增加
	 * 
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByDay(Date date, int days) {
		if(days==0){
			return date;
		}
		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	/**
	 * 日期增加-按月增加
	 * 
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByMonth(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.MONTH, mnt);

		return cal.getTime();
	}

	/**
	 * 日期增加-按年增加
	 * 
	 * @param date
	 * @param mnt
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByYear(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.YEAR, mnt);

		return cal.getTime();
	}

	/**
	 * 日期增加
	 * 
	 * @param date
	 *            日期字符yyyy-MM-dd
	 * @param days
	 * @return 日期字符yyyy-MM-dd
	 */
	public static String dateIncreaseByDay(String date, int days) {
		return dateIncreaseByDay(date, ISO_DATE_FORMAT, days);
	}

	/**
	 * 日期增加
	 * 
	 * @param date
	 *            日期字符
	 * @param fmt
	 *            日期格式
	 * @param days
	 * @return
	 */
	public static String dateIncreaseByDay(String date, String fmt, int days) {
		return dateIncrease(date, fmt, Calendar.DATE, days);
	}

	/**
	 * 日期字符串格式转
	 * 
	 * @param src
	 *            日期字符
	 * @param srcfmt
	 *            源日期格
	 * @param desfmt
	 *            目标日期格式
	 * @return
	 */
	public static String stringToString(String src, String srcfmt, String desfmt) {
		return dateToString(stringToDate(src, srcfmt), desfmt);
	}

	/**
	 * 取得当前日期是星期几 按前台的习惯,从周
	 * 
	 * @return
	 */
	public static int getCurrentWeekDay() {
		Date date = getCurrentDateTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int[] defineWeek = new int[] { 7, 1, 2, 3, 4, 5, 6 };
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		return defineWeek[weekDay - 1];
	}

	public static String getWeekDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int[] defineWeek = new int[] { 7, 1, 2, 3, 4, 5, 6 };
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		String weekStr = null;
		Integer weekIndex = defineWeek[weekDay - 1];
		switch (weekIndex) {
		case 7:
			weekStr = "星期日";
			break;
		case 1:
			weekStr = "星期一";
			break;
		case 2:
			weekStr = "星期二";
			break;
		case 3:
			weekStr = "星期三";
			break;
		case 4:
			weekStr = "星期四";
			break;
		case 5:
			weekStr = "星期五";
			break;
		case 6:
			weekStr = "星期六";
			break;
		default:
			break;
		}
		return weekStr;
	}

	public static String getCurrentWeekDayToStr() {
		int weekIndex = getCurrentWeekDay();
		String weekStr = null;
		switch (weekIndex) {
		case 7:
			weekStr = "星期日";
			break;
		case 1:
			weekStr = "星期一";
			break;
		case 2:
			weekStr = "星期二";
			break;
		case 3:
			weekStr = "星期三";
			break;
		case 4:
			weekStr = "星期四";
			break;
		case 5:
			weekStr = "星期五";
			break;
		case 6:
			weekStr = "星期六";
			break;
		default:
			break;
		}
		return weekStr;
	}

	/**
	 * 取得本周星期几的日期
	 * 
	 * @param date
	 * @param weekIndex
	 *            按前台的习惯,从周
	 * @return
	 */
	public static String getWeekday(String strDate, int weekIndex, String fmt) {
		if (strDate == null || strDate.isEmpty() || weekIndex < 1
				|| weekIndex > 7)
			return "";
		if (fmt == null || fmt.isEmpty())
			fmt = ISO_EXPANDED_DATE_FORMAT;
		if (weekIndex == 7)
			strDate = dateIncreaseByDay(strDate, fmt, 7);
		Date date = stringToDate(strDate);
		Calendar c = Calendar.getInstance();
		int[] weeks = new int[] { Calendar.MONDAY, Calendar.TUESDAY,
				Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY,
				Calendar.SATURDAY, Calendar.SUNDAY, };
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, weeks[weekIndex - 1]);
		return new SimpleDateFormat(fmt).format(c.getTime());
	}

	public static String beforeOneHourToNowDate(String fmt) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.get(Calendar.HOUR_OF_DAY) - 1);
		SimpleDateFormat df = new SimpleDateFormat(fmt);

		// System.out.println("�?��小时前的时间�?+ df.format(calendar.getTime()));

		// System.out.println("当前的时间："+ df.format(new Date()));
		return df.format(calendar.getTime());
	}

	/**
	 * 获取日期年份
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小
	 *
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分
	 *
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫
	 *
	 * @param date
	 *            日期
	 * @return 返回
	 */
	public static long getMillis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	public static Date getMonthFirstTime() {
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		cal_1.set(Calendar.HOUR_OF_DAY, 0);
		cal_1.set(Calendar.MINUTE, 0);
		cal_1.set(Calendar.SECOND, 0);
		return cal_1.getTime();
	}

	public static Date getWeekFirstTime() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.setFirstDayOfWeek(Calendar.MONDAY);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return (Date) currentDate.getTime();
	}

	public static Date getTodayFirstTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}

	public static Date getDayFirstTime(Date date) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(date);
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}

	public static Date getTodayLastTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 23);
		todayStart.set(Calendar.SECOND, 59);
		todayStart.set(Calendar.MINUTE, 59);
		todayStart.set(Calendar.MILLISECOND, 999);
		return todayStart.getTime();
	}

	public static Date getDayLastTime(Date date) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(date);
		todayStart.set(Calendar.HOUR_OF_DAY, 23);
		todayStart.set(Calendar.SECOND, 59);
		todayStart.set(Calendar.MINUTE, 59);
		todayStart.set(Calendar.MILLISECOND, 999);
		return todayStart.getTime();
	}

	public static Date getTime(Date date, Integer addDay) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(date);
		todayStart.add(Calendar.DATE, addDay);
		// todayStart.add(Calendar.HOUR,addDay);
		return todayStart.getTime();
	}

	// mm:ss:SSS
	public static String getLeftTime(Date bigDate, Date smallDate) {
		long millTemp = bigDate.getTime() - smallDate.getTime();
		long mill = millTemp % 1000;
		long secTemp = millTemp / 1000;
		long sec = secTemp % 60;
		long min = secTemp / 60;
		String millStr = String.valueOf(mill);
		if (millStr.length() < 3) {
			for (int i = millStr.length(); i < 3; i++) {
				millStr = "0" + millStr;
			}
		}
		return (min > 10 ? min : ("0" + min)) + ":"
				+ (sec > 10 ? sec : ("0" + sec)) + ":" + millStr;
	}

	public static Date getYesYearTime() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.YEAR, -1);
		return (Date) currentDate.getTime();
	}

	public static void main(String[] args) {
		/*System.out.println(dateToString(getYesYearTime(), DATETIME_PATTERN));
		System.out.println(DateUtil.daysBetween(new Date(), DateUtil.dateIncreaseByDay(new Date(),3)));
		//DATETIME_PATTERN = "yyyy/MM/dd HH:mm:ss"
		Date startTime = DateUtil.stringToDate("2017/01/22 00:00:00", DATETIME_PATTERN);
		Date endTime = DateUtil.stringToDate("2017/01/28 23:59:59", DATETIME_PATTERN);
		System.out.println(DateUtil.daysBetween(startTime, endTime));*/
		//System.out.println(DateUtil.getYear(new Date()));
		System.out.println(dateToString(new Date(), "MM-dd HH:mm"));
	}
}
