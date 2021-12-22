package ir.farzanehfar.session_5.e22;

import org.apache.log4j.Logger;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeJava8Test {
    final static Logger logger = Logger.getLogger(DateTimeJava8Test.class);

    public static void main(String[] args) {

        // java.time.LocalDate **---------------------------------
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        date1 = date1.plusDays(2);
        date1 = date1.minusDays(1);
        date1 = date1.plusWeeks(2);
        date1 = date1.minusWeeks(1);
        date1 = date1.plusMonths(2);
        date1 = date1.minusMonths(1);

        // java.time.LocalTime **---------------------------------
        LocalTime time1 = LocalTime.of(6, 15); // hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds


        // java.time.LocalDateTime **---------------------------------
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

        // java.time.Period **---------------------------------
        Period annually = Period.ofYears(1); // every 1 year
        Period quarterly = Period.ofMonths(3); // every 3 months
        Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
        Period everyOtherDay = Period.ofDays(2); // every 2 days
        Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Period period = Period.ofMonths(1);
        logger.info(date.plus(period)); // 2015-02-20
        logger.info(dateTime.plus(period)); // 2015-02-20T06:15
        logger.info(time.plus(period)); // UnsupportedTemporalTypeException

        // java.time.format.DateTimeFormatter **---------------------------------
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm");
        logger.info(f.format(dateTime));
        logger.info(f.format(date)); // UnsupportedTemporalTypeException
        logger.info(f.format(time));
    }
}
