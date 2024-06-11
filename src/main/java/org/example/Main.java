package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        //LocalDate = nur Datum
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        //LocalDateTime = Datum & Uhrzeit
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        //ZonedDateTime =============== Datum & Uhrzeit & Zeitzone
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
        //d = Tag | M = Monat | y = Jahr |H = Stunde | m= Minute | s = Sekunde | n = nano
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
    }
}