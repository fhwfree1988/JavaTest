package ir.farzanehfar.session_5.e21;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeTest {
    final static Logger logger = Logger.getLogger(DateTimeTest.class);

    public static void main(String[] args) {
        logger.info("current time in milli second: " + System.currentTimeMillis());

        // java.util.Date **---------------------------------
        Date date = new Date();
        logger.info(date);

        long now = System.currentTimeMillis();
        date = new Date(now);
        logger.info(date);

        Date date1 = new Date();
        Date date2 = new Date();

        int comparison = date1.compareTo(date2);

        boolean isBefore = date1.before(date2);
        boolean isAfter = date1.after(date2);

        // java.util.Calendar **---------------------------------
        Calendar calendar = new GregorianCalendar();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR);        // 12 hour clock
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);

        //set date to last day of 2009
        calendar.set(Calendar.YEAR, 2009);
        calendar.set(Calendar.MONTH, 11); // 11 = december
        calendar.set(Calendar.DAY_OF_MONTH, 31); // new years eve

        //add one day
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        //date is now jan. 1st 2010
        year = calendar.get(Calendar.YEAR);  // now 2010
        month = calendar.get(Calendar.MONTH); // now 0 (Jan = 0)
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // now 1


        // java.text.SimpleDateFormat **---------------------------------
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        logger.info(format.format(date));
    }
}
