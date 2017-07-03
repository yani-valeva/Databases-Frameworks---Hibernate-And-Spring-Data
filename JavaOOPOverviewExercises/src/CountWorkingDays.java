import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class CountWorkingDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String start = scanner.nextLine();
        String end = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);

        LocalDate[] holidays = new LocalDate[11];
        holidays[0] = LocalDate.parse("01-01-2017", formatter);
        holidays[1] = LocalDate.parse("03-03-2017", formatter);
        holidays[2] = LocalDate.parse("01-05-2017", formatter);
        holidays[3] = LocalDate.parse("06-05-2017", formatter);
        holidays[4] = LocalDate.parse("24-05-2017", formatter);
        holidays[5] = LocalDate.parse("06-09-2017", formatter);
        holidays[6] = LocalDate.parse("22-09-2017", formatter);
        holidays[7] = LocalDate.parse("01-11-2017", formatter);
        holidays[8] = LocalDate.parse("24-12-2017", formatter);
        holidays[9] = LocalDate.parse("25-12-2017", formatter);
        holidays[10] = LocalDate.parse("26-12-2017", formatter);

        int workingDaysCounter = 0;

        for (LocalDate date = startDate; date.isBefore(endDate) || date.isEqual(endDate); date = date.plusDays(1)) {
            String dayOfWeek = date.getDayOfWeek().toString();
            if (!dayOfWeek.equals("SATURDAY") && !dayOfWeek.equals("SUNDAY") && !IsHoliday(holidays, date)) {
                workingDaysCounter++;
            }
        }
        System.out.println(workingDaysCounter);
    }

    public static boolean IsHoliday(LocalDate[] holidays, LocalDate date) {
        boolean isHoliday = false;

        for (int i = 0; i < 11; i++) {
            if (holidays[i].getMonth() == date.getMonth() && holidays[i].getDayOfMonth() == date.getDayOfMonth()) {
                isHoliday = true;
                break;
            }
        }

        return isHoliday;
    }
}