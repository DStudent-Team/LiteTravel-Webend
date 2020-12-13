package com.LiteTravel.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomUtils {
    private static double Pi = 3.1415926535898;
    private static double R = 6371004;

    public static double getDistance(double MLatA, double MLngA, double MLatB, double MLngB) {
        double C = Math.sin(MLatA) * Math.sin(MLatB) * Math.cos(MLngA - MLngB) + Math.cos(MLatA) * Math.cos(MLatB);
        return R * Math.acos(C) * Pi / 180;
    }

    public static Integer getDayDiff(Date startDate, Date endDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long endDateTime = 0;
        long startDateTime = 0;
        try {
            startDateTime = dateFormat.parse(dateFormat.format(startDate)).getTime();
            endDateTime = dateFormat.parse(dateFormat.format(endDate)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
    }
}
