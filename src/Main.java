import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        concludedLongMonths(2016);
        getDateMonday(2016, 2);
        System.out.println(isFriday13(2017, 1, 13));
        getElapsedTime(2016, 10, 2);
        localTime();
    }

    private static void concludedLongMonths(int year) {
        Calendar date = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            date.set(year, i, 1);
            System.out.println(date.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
    }

    private static void getDateMonday(int year, int month) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        for (int i = 0; i <= date.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            date.set(year, month - 1, i);
            if (date.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                System.out.println(i + " - " + "Monday");
            }
        }
    }

    private static boolean isFriday13(int year, int month, int day) {
        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, day);
        return (day == 13 && date.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY);
    }

    private static void getElapsedTime(int year, int month, int day) {
        LocalDate today = LocalDate.now();
        LocalDate then = LocalDate.of(year, month, day);
        Period period = Period.between(then, today);
        System.out.println("Years = " + period.getYears() + " Month = " + period.getMonths() + " Days = " + period.getDays());
    }

    private static void localTime() {
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        ZonedDateTime canadaTime = today.atZone(ZoneId.of("-07:00"));
        System.out.println(canadaTime);
    }
}
