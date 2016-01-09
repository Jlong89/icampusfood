/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Joey
 */
public class DateTimeUtil {
    private static Calendar calendar = Calendar.getInstance();

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static Timestamp getRandomOpenTime(){
        int random = getRandomNumberInRange(7,12);
        calendar.set(0,0,0,random,0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getRandomCloseTime(){
        int random = getRandomNumberInRange(16,23);
        calendar.set(0,0,0,random,0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getRandomStartDate(){
        int random = getRandomNumberInRange(1,11);
        calendar.set(0,random,0,0,0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static int getHourFromTimeString(String s){
        String[] sArr = s.split(":");
        if(sArr.length<2) return -1;
        return Integer.parseInt(sArr[0]);
    }
    public static int getMinFromTimeString(String s){
        String[] sArr = s.split(":");
        if(sArr.length<2) return -1;
        return Integer.parseInt(sArr[1]);
    }
    public static int getYearFromDateString(String s){
        String[] sArr = s.split("/");
        if(sArr.length<3) return -1;
        return Integer.parseInt(sArr[0]);
    }
    public static int getMonthFromDateString(String s){
        String[] sArr = s.split("/");
        if(sArr.length<3) return -1;
        return Integer.parseInt(sArr[1]);
    }
    public static int getDayFromDateString(String s){
        String[] sArr = s.split("/");
        if(sArr.length<3) return -1;
        return Integer.parseInt(sArr[2]);
    }
    
    public static int getHourFromTimestamp(long timestamp){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        return c.get(Calendar.HOUR_OF_DAY);
    }
    public static int getMinFromTimestamp(long timestamp){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        return c.get(Calendar.MINUTE);
    }
    public static int getYearFromTimestamp(long timestamp){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        return c.get(Calendar.YEAR);
    }
    public static int getMonthFromTimestamp(long timestamp){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        return c.get(Calendar.MONTH);
    }
    public static int getDayFromTimestamp(long timestamp){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        return c.get(Calendar.DAY_OF_MONTH);
    }
    
    
    public static String getHourMinStringFromTimestamp(Timestamp timestamp){
        String sec = String.valueOf(getMinFromTimestamp(timestamp.getTime()));
        if(sec.equals("0")) sec+="0";
        return String.valueOf(getHourFromTimestamp(timestamp.getTime()))+":"+sec;
    }
    
    public static String getYearMonthDayStringFromTimestamp(Timestamp timestamp){
        return String.valueOf(getYearFromTimestamp(timestamp.getTime()))+"/"+String.valueOf(getMonthFromTimestamp(timestamp.getTime()))+"/"+String.valueOf(getDayFromTimestamp(timestamp.getTime()));
    }
    
    public static String getMonthDayStringFromDate(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return String.valueOf(c.get(Calendar.MONTH))+"/"+String.valueOf(c.get(Calendar.DAY_OF_MONTH));
    }
    
    
}
