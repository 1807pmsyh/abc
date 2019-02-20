package com.zs.pms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * ��õ�ǰʱ��ķ������ַ�����
	 * 
	 * @return ���ص�ǰ���ַ���
	 */
	public static String getStrDate() {
		// �����������
		Calendar cal = Calendar.getInstance();
		// ��ǰ��
		int y = cal.get(Calendar.YEAR);
		// ��ǰ��
		int m = cal.get(Calendar.MONTH);
		// ��ǰ��
		int d = cal.get(Calendar.DAY_OF_MONTH);
		// ��ǰʱ
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		// ��ǰ��
		// int minute= cal.get(Calendar.MINUTE);
		// ��ǰ��
		// int second= cal.get(Calendar.SECOND);
		// ��ʾ�����ʱʲôʱ��
		String str = "";
		//
		if (hh > 6 && hh <= 11) {
			str = "�����!";
		} else if (hh > 11 && hh <= 14) {
			str = "�����!";
		} else if (hh > 14 && hh <= 18) {
			str = "�����!";
		} else if (hh > 18 && hh < 24) {
			str = "���Ϻ�!";
		} else {
			str = "����Ҫ��Ϣ��!";
		}

		return y + "-" + m + "-" + d + " " + str;

	}

	/**
	 * DateתStringʱ��ķ���
	 * 
	 * @param time
	 *            Date���ʱ��
	 * @param pattern
	 *            ��ʱ���ʽ����ʲô��
	 * @return �ַ������ʱ��
	 */
	public static String getDateToStr(Date time, String pattern) {
		// ��ø�ʽ������
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// ���ظ�ʽ���õ�ʱ��

		// Date date = new Date();
		return sdf.format(time);

	}

	/**
	 * �ַ���תΪDate�ķ���
	 * 
	 * @param time
	 *            �ַ���
	 * @param pattern
	 *            �����ַ�����ʱ���ʽ
	 * @return date��ʱ��
	 * @throws ParseException
	 */
	public static Date getStrToDate(String time, String pattern) throws ParseException {
		// ��ø�ʽ������
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// ���ظ�ʽ���õ�ʱ��
		return sdf.parse(time);

	}
}
