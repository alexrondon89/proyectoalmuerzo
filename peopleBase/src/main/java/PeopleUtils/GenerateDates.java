package PeopleUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateDates {

    public static String getCurrentDate() {
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of( "America/Buenos_Aires" );
        ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String currentDate = zdt.format(formatter);

        System.out.println("Geting current date: " + currentDate);

        return currentDate;
    }
}
