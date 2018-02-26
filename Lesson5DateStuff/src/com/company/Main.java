package com.company;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Date joshua = new GregorianCalendar(1987,3,9).getTime();
        Date rattle = new GregorianCalendar(1988,10,10).getTime();

        Date today = new Date();

        long diff = rattle.getTime() - joshua.getTime();

        System.out.println( (diff / (1000 * 60 * 60 * 24)) + " days.");

        long newDate = today.getTime() + diff;
        Date nextAlbum = new Date(newDate);

        DateFormat formatter = DateFormat.getDateTimeInstance(
                DateFormat.LONG,
                DateFormat.LONG,
                Locale.US);

        System.out.print("Next Album:");

        System.out.println(formatter.format(nextAlbum));

    }
}
