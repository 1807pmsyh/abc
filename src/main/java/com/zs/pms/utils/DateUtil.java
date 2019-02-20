package com.zs.pms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 获得当前时间的方法（字符串）
	 * 
	 * @return 返回当前的字符串
	 */
	public static String getStrDate() {
		// 获得日历对象
		Calendar cal = Calendar.getInstance();
		// 当前年
		int y = cal.get(Calendar.YEAR);
		// 当前月
		int m = cal.get(Calendar.MONTH);
		// 当前日
		int d = cal.get(Calendar.DAY_OF_MONTH);
		// 当前时
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		// 当前分
		// int minute= cal.get(Calendar.MINUTE);
		// 当前秒
		// int second= cal.get(Calendar.SECOND);
		// 提示输入的时什么时间
		String str = "";
		//
		if (hh > 6 && hh <= 11) {
			str = "上午好!";
		} else if (hh > 11 && hh <= 14) {
			str = "中午好!";
		} else if (hh > 14 && hh <= 18) {
			str = "下午好!";
		} else if (hh > 18 && hh < 24) {
			str = "晚上好!";
		} else {
			str = "您需要休息啦!";
		}

		return y + "-" + m + "-" + d + " " + str;

	}

	/**
	 * Date转String时间的方法
	 * 
	 * @param time
	 *            Date类的时间
	 * @param pattern
	 *            把时间格式化成什么样
	 * @return 字符串类的时间
	 */
	public static String getDateToStr(Date time, String pattern) {
		// 获得格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 返回格式化好的时间

		// Date date = new Date();
		return sdf.format(time);

	}

	/**
	 * 字符串转为Date的方法
	 * 
	 * @param time
	 *            字符串
	 * @param pattern
	 *            输入字符串的时间格式
	 * @return date的时间
	 * @throws ParseException
	 */
	public static Date getStrToDate(String time, String pattern) throws ParseException {
		// 获得格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 返回格式化好的时间
		return sdf.parse(time);

	}
}
