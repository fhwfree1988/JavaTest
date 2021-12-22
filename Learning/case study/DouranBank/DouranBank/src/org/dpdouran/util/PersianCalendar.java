package org.dpdouran.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author H. Farzanehfar
 */
public class PersianCalendar {
	public static final String[] PersianMonths = new String[] { "\u0641\u0631\u0648\u0631\u062f\u06cc\u0646",
			"\u0627\u0631\u062f\u06cc\u0628\u0647\u0634\u062a", "\u062e\u0631\u062f\u0627\u062f", "\u062a\u06cc\u0631",
			"\u0645\u0631\u062f\u0627\u062f", "\u0634\u0647\u0631\u06cc\u0648\u0631", "\u0645\u0647\u0631",
			"\u0622\u0628\u0627\u0646", "\u0622\u0630\u0631", "\u062f\u06cc", "\u0628\u0647\u0645\u0646",
			"\u0627\u0633\u0641\u0646\u062f" };
	public final String[] PersianDaysOfWeek = new String[] { "\u06cc\u06a9\u0634\u0646\u0628\u0647",
			"\u062f\u0648\u0634\u0646\u0628\u0647", "\u0633\u0647 \u0634\u0646\u0628\u0647",
			"\u0686\u0647\u0627\u0631\u0634\u0646\u0628\u0647", "\u067e\u0646\u062c\u0634\u0646\u0628\u0647",
			"\u062c\u0645\u0639\u0647", "\u0634\u0646\u0628\u0647" };

	public final String Am = "\u0642\u002e\u0638\u002e", Pm = "\u0628\u002e\u0638\u002e";

	// private fields
	public final int[] gregorianDaysInMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public final int[] persianDaysInMonth = new int[] { 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29 };
	private Calendar cal;
	private int persianDay, persianMonth, persianYear;

	public PersianCalendar(int Year, int Month, int Day, int Hours, int Minutes, int Seconds) {
		if (Hours > 23 || Hours < 0) {
			throw new RuntimeException("Invalid persian time!");
		}

		if (Minutes > 59 || Minutes < 0) {
			throw new RuntimeException("Invalid persian time!");
		}

		if (Seconds > 59 || Seconds < 0) {
			throw new RuntimeException("Invalid persian time!");
		}

		PersianCalendar pc = new PersianCalendar(Year, Month, Day);
		cal = newCalendarZero();
		cal.setTime(pc.getGregorianDate());

		cal.set(Calendar.HOUR_OF_DAY, Hours);
		cal.set(Calendar.MINUTE, Minutes);
		cal.set(Calendar.SECOND, Seconds);
	}

	public PersianCalendar(int Year, int Month, int Day) {

		if (Month == 12) {
			int md = isLeap(Year) ? 30 : 29;
			if (Day > md) {
				throw new RuntimeException("Invalid persian date!");
			}
		} else if (Day > persianDaysInMonth[Month - 1]) {
			throw new RuntimeException("Invalid persian date!");
		}

		int gYear, gMonth, gDay;
		int pYear, pMonth, pDay;
		int gDayNo, pDayNo;
		int leap;
		int i;

		pYear = Year - 979;
		pMonth = Month - 1;
		pDay = Day - 1;

		pDayNo = 365 * pYear + (pYear / 33) * 8 + (((pYear % 33) + 3) / 4);
		for (i = 0; i < pMonth; ++i) {
			pDayNo += persianDaysInMonth[i];
		}

		pDayNo += pDay;

		gDayNo = pDayNo + 79;

		gYear = 1600 + 400 * (gDayNo / 146097);
		/*
		 * 146097 = 365*400 + 400/4 - 400/100 + 400/400
		 */
		gDayNo = (gDayNo % 146097);

		leap = 1;

		/*
		 * 36525 = 365*100 + 100/4
		 */
		if (gDayNo >= 36525) {
			gDayNo--;
			gYear += 100 * (gDayNo / 36524);
			/*
			 * 36524 = 365*100 + 100/4 - 100/100
			 */
			gDayNo = (gDayNo % 36524);

			if (gDayNo >= 365) {
				gDayNo++;
			} else {
				leap = 0;
			}
		}

		gYear += 4 * (gDayNo / 1461);
		/*
		 * 1461 = 365*4 + 4/4
		 */
		gDayNo = (gDayNo % 1461);

		if (gDayNo >= 366) {
			leap = 0;

			gDayNo--;
			gYear += (gDayNo / 365);
			gDayNo = (gDayNo % 365);
		}

		for (i = 0; gDayNo >= gregorianDaysInMonth[i] + ((i == 1 && leap == 1) ? 1 : 0); i++) {
			gDayNo -= gregorianDaysInMonth[i] + ((i == 1 && leap == 1) ? 1 : 0);
		}
		gMonth = i + 1;
		gDay = gDayNo + 1;

		cal = newCalendarZero();
		cal.set(Calendar.YEAR, gYear);
		cal.set(Calendar.MONTH, gMonth - 1);
		cal.set(Calendar.DAY_OF_MONTH, gDay);

		this.persianDay = Day;
		this.persianMonth = Month;
		this.persianYear = Year;
	}

	public PersianCalendar(Date gregorianDate) {
		cal = newCalendarZero();
		cal.setTime(gregorianDate);

		int gYear, gMonth, gDay;
		int pYear, pMonth, pDay;
		int gDayNo, pDayNo;
		int pNP;

		int i;

		gYear = (gregorianDate.getYear() + 1900) - 1600;
		gMonth = (gregorianDate.getMonth() + 1) - 1;
		gDay = gregorianDate.getDate() - 1;

		gDayNo = 365 * gYear + ((gYear + 3) / 4) - ((gYear + 99) / 100) + ((gYear + 399) / 400);
		for (i = 0; i < gMonth; ++i) {
			gDayNo += gregorianDaysInMonth[i];
		}

		/*
		 * leap and after Feb
		 */
		if (gMonth > 1 && ((gYear % 4 == 0 && gYear % 100 != 0) || (gYear % 400 == 0))) {
			++gDayNo;
		}
		gDayNo += gDay;

		pDayNo = gDayNo - 79;

		pNP = (pDayNo / 12053);
		pDayNo = (pDayNo % 12053);

		pYear = 979 + 33 * pNP + 4 * (pDayNo / 1461);
		pDayNo = (pDayNo % 1461);

		if (pDayNo >= 366) {
			pYear += ((pDayNo - 1) / 365);
			pDayNo = ((pDayNo - 1) % 365);
		}

		for (i = 0; i < 11 && pDayNo >= persianDaysInMonth[i]; ++i) {
			pDayNo -= persianDaysInMonth[i];
		}
		pMonth = i + 1;
		pDay = pDayNo + 1;

		persianYear = pYear;
		persianMonth = pMonth;
		persianDay = pDay;
	}

	public PersianCalendar(String pdate) {
		String[] v = pdate.split("/");
		if (v.length != 3) {
			throw new RuntimeException("Invalid persian date format!");
		}
		int y = Integer.parseInt(v[0]);
		int m = Integer.parseInt(v[1]);
		int d = Integer.parseInt(v[2]);

		PersianCalendar pc = new PersianCalendar(y, m, d);
		this.cal = pc.cal;
		this.persianDay = pc.persianDay;
		this.persianMonth = pc.persianMonth;
		this.persianYear = pc.persianYear;
	}

	public Date getGregorianDate() {
		return cal.getTime();
	}

	private boolean isLeap(int year) {
		int rem = (year % 33);
		switch (rem) {
		case 1:
			return true;
		case 5:
			return true;
		case 9:
			return true;
		case 13:
			return true;
		case 17:
			return true;
		case 22:
			return true;
		case 26:
			return true;
		case 30:
			return true;
		default:
			return false;
		}
	}

	public int getPersianDay() {
		return persianDay;
	}

	public int getPersianMonth() {
		return persianMonth;
	}

	public int getPersianYear() {
		return persianYear;
	}

	@Override
	public String toString() {

		String s = persianYear + "/";
		s += String.format("%02d", persianMonth) + "/";
		s += String.format("%02d", persianDay);
		return s;
	}

	public String toString(String format) {
		if (format == null || format.trim().equals(""))
			return toString();

		// y: Year
		// "yyyy" -> "2003"
		format = format.replaceAll("yyyy", String.valueOf(persianYear));
		// "yy" -> "03"
		format = format.replaceAll("yy", String.valueOf(persianYear % 100));

		// M : Month
		// "MMMM" -> "December"
		format = format.replaceAll("MMMM", PersianMonths[persianMonth - 1]);
		// "MMM" -> "Jul"
		int maxLength = (PersianMonths[persianMonth - 1].length() < 3) ? PersianMonths[persianMonth - 1].length() : 3;
		format = format.replaceAll("MMM", PersianMonths[persianMonth - 1].substring(0, maxLength));
		// "MM" -> "07"
		format = format.replaceAll("MM", String.format("%02d", persianMonth));
		// "M" -> "7"
		format = format.replaceAll("M", String.valueOf(persianMonth));

		// d : Day in month
		// "dd" -> "03"
		format = format.replaceAll("dd", String.format("%02d", persianDay));
		// "d" -> "3"
		format = format.replaceAll("d", String.valueOf(persianDay));

		// h : Hour (1-12, AM/PM)
		// "hh" -> "07"
		format = format.replaceAll("hh", String.format("%02d", cal.get(Calendar.HOUR)));
		// "h" -> "12"
		format = format.replaceAll("h", String.valueOf(cal.get(Calendar.HOUR)));

		// H : Hour (0-23)
		// "HH" -> "07"
		format = format.replaceAll("HH", String.format("%02d", cal.get(Calendar.HOUR_OF_DAY)));
		// "H" -> "7"
		format = format.replaceAll("H", String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));

		// k : Hour (1-24)
		// "kk" -> "24"
		format = format.replaceAll("kk", String.format("%02d", cal.get(Calendar.HOUR_OF_DAY) + 1));
		// "k" -> "02"
		format = format.replaceAll("k", String.valueOf(cal.get(Calendar.HOUR_OF_DAY) + 1));

		// a AM/PM
		// "aa" -> "AM"
		format = format.replaceAll("aa", cal.get(Calendar.AM_PM) == Calendar.AM ? Am : Pm);
		// "a" -> "AM"
		format = format.replaceAll("aa", cal.get(Calendar.AM_PM) == Calendar.AM ? Am : Pm);

		// m : Minute
		// "mm" -> "07"
		format = format.replaceAll("mm", String.format("%02d", cal.get(Calendar.MINUTE)));
		// "m" -> "7"
		format = format.replaceAll("m", String.valueOf(cal.get(Calendar.MINUTE)));

		// s : Second
		// "ss" -> "07"
		format = format.replaceAll("ss", String.format("%02d", cal.get(Calendar.SECOND)));
		// "s" -> "15"
		format = format.replaceAll("s", String.valueOf(cal.get(Calendar.SECOND)));

		// E : Day in week
		// "EEEE" -> "Tuesday"
		format = format.replaceAll("EEEE", PersianDaysOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1]);
		// "EEE" -> "Tue"
		maxLength = (PersianDaysOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1].length() < 3)
				? PersianDaysOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1].length()
				: 3;
		format = format.replaceAll("EEE", PersianDaysOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1].substring(0, maxLength));

		return format;
	}

	public String getPersianDayOfWeek() {
		return PersianDaysOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public String getPersianMonthString() {
		return PersianMonths[persianMonth - 1];
	}

	public static Calendar newCalendarZero() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal;
	}

	public static void main(String[] args) {
		// PersianCalendar pc = new PersianCalendar(1390, 11, 30);
		// System.out.println(pc.getGregorianDate());
		// System.out.println();
		// System.out.println();

		Date dt = new Date();
		PersianCalendar pc2 = new PersianCalendar(1390, 1, 2);
		System.out.println(pc2.toString("EEEE d MMMM yyyy HH:mm"));
	}
}