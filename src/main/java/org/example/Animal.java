package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Write a class Animal and add an attribute birthday and name to it.
//Create an instance of the Animal class. => Main.java
//Print on the command line how many days are left until the next birthday of the animal.
@Data
@AllArgsConstructor
public class Animal {
    private String name;
    private LocalDate birthday;

    public long daysUntilNextBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthday.withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) nextBirthday = nextBirthday.plusYears(1);
        return ChronoUnit.DAYS.between(today, nextBirthday);

    }

    public void printBirthdayMemory() {
        System.out.println("The birthday of your cat " + name + " is in " + daysUntilNextBirthday() + " days!");
    }

}
