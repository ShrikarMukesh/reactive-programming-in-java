package com.rapidapi.utilities;
import java.sql.Timestamp;
import java.util.Date;

public class TimeConTest {
    public static void main(String args[]) {

        Timestamp t = new Timestamp(System.currentTimeMillis());
        System.out.println(t);//for current time in milliseconds
        Date d = new Date(t.getTime());
        System.out.println(d);


    }
}
