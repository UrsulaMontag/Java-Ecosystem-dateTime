package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        //Lecture examples
        //LocalDate = nur Datum
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        //LocalDateTime = Datum & Uhrzeit
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        //ZonedDateTime = Datum & Uhrzeit & Zeitzone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zonedDateTime);

        //Instant = Zulu Zeitpunkt
        Instant instant = Instant.now();
        System.out.println("Instant: " + instant);

        //Umwandlung Instant zu LocalDateTime
        ZoneId zoneId = ZoneId.of("Europe/Berlin");
        // oder ZoneId.systemDefault()
        LocalDateTime convertedDateTime = LocalDateTime.ofInstant(instant, zoneId);
        System.out.println("ConvertedDateTime: " + convertedDateTime);

        //Umwandlung LocalDateTime zu Instant
        Instant convertedInstant = localDateTime.atZone(zoneId).toInstant();
        System.out.println("ConvertedInstant: " + convertedInstant);

        //Format der Zeitangabe anpassen
        //d = Tag | M = Monat | y = Jahr | H = Stunde | m= Minute | s = Sekunde | n = nano
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
        System.out.println(localDateTime.format(formatter));

        //Umwandlung String in LocalDate
        LocalDate parsedLocalDate = LocalDate.parse("12.August.2024", formatter);
        System.out.println("Parse string to localdate: " + parsedLocalDate);

        //Differenz zwischen zwei Zeitpunkten errechnen
        LocalDateTime start = LocalDateTime.of(2024, 6, 11, 12, 00, 00);
        LocalDateTime finish = LocalDateTime.now();
        long hoursBetween = ChronoUnit.HOURS.between(start, finish);
        long minutesBetween = ChronoUnit.MINUTES.between(start, finish); //nimmt kompletten Zeitraum in minuten -> nanosekunden berechnen und dann in h:m:s umrechnen
        System.out.println("hours between start and finish: " + hoursBetween);

        //Challenges
        //Call methods from Challenges
        System.out.println("Current date and time: " + getCurrentDateAndTime());
        System.out.println("Current date plus 2 weeks: " + add2WeeksToCurrentDate());
        System.out.println("Is current date before specified date: " + isCurrentDateBeforeSpecifiedDate());
        System.out.println("Get out days between two dates: " + getDifferenceOfDays());

        
        //Method Call from Bonus
        Animal animal1 = new Animal("Baghira", LocalDate.of(2017, 11, 3));
        Animal animal2 = new Animal("Django", LocalDate.of(2019, 8, 12));

        animal1.printBirthdayMemory();
        animal2.printBirthdayMemory();
    }

    //Challenges
    //Step 1: Write code to output the current date and time.
    private static LocalDateTime getCurrentDateAndTime() {
        return LocalDateTime.now();
    }

    //Step 2: Add a timespan of 2 weeks to the current date and output the new date.
    private static LocalDateTime add2WeeksToCurrentDate() {
        return getCurrentDateAndTime().plusWeeks(2);
    }

    //Step 3: Compare the current date with a specified future date and output whether the
    //current date is before or after the specified date.
    private static boolean isCurrentDateBeforeSpecifiedDate() {
        LocalDateTime futureDate = add2WeeksToCurrentDate();
        return getCurrentDateAndTime().isBefore(futureDate);
    }

    //Step 4: Calculate the difference in days between two arbitrary dates and output the result.
    private static long getDifferenceOfDays() {
        LocalDateTime start = getCurrentDateAndTime().minusWeeks(3);
        LocalDateTime end = add2WeeksToCurrentDate();
        return ChronoUnit.DAYS.between(start, end);
    }
}