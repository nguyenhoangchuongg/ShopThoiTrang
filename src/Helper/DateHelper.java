/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hoangchuongnguyen
 */
public class DateHelper {
//
//    static SimpleDateFormat formater = new SimpleDateFormat();
//    public static Date toDate(String date, String pattern) {
//        try {
//            formater.applyPattern(pattern);
//            return formater.parse(date);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static String toString(Date date, String pattern) {
//        formater.applyPattern(pattern);
//        return formater.format(date);
//    }
//    public  static Date addDays (Date date, long days){
//        date.setTime(date.getTime()+days*24*60*60*1000);
//        return date;
//    }
    public static Date now() {
        return new Date();
    }
    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {

                DATE_FORMATER.applyPattern(pattern[0]);

            }
            if (date == null) {
                return DateHelper.now();
            }
            System.out.println(date);
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMATER.format(date);
    }

    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }

}
