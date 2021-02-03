import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class FormattingDateAndTime {

  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2010, Month.APRIL, 8);
    LocalTime time = LocalTime.of(3, 9, 33);
    LocalDateTime dateTime = LocalDateTime.of(date, time);

    System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
    System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
    System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    DateTimeFormatter mediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    //SHORT prints two numbers for year while medium prints 4 numbers for year.

    System.out.println();
    System.out.println(shortFormatter.format(dateTime));
    System.out.println(mediumFormatter.format(date));
//    System.out.println(shortFormatter.format(time));//UnsupportedTemporalTypeException because we use
    //time as a parameter while we work with DateTimeFormatter.ofLocalizedDate()
    System.out.println();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M d y, h:m");
    System.out.println(dateTime.format(formatter));
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM dd yy, h:m");
    System.out.println(dateTime.format(formatter2));
    DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MMM dd yyy, hh:mm");
    System.out.println(dateTime.format(formatter3));
    DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("MMMM dd yyyy, hh:mm");
    System.out.println(dateTime.format(formatter4));

    //before Java 8
    System.out.println();
    SimpleDateFormat sf = new SimpleDateFormat("hh:mm");
    System.out.println(sf.format(new Date()));

    System.out.println();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
    System.out.println(dtf.format(dateTime));
//    System.out.println(dtf.format(date));will not work at run time since this is date and not time
    System.out.println(dtf.format(time));

  }

}
