package com.wharf.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/24.
 */
public class DateUtils {

    private  final static String yyyyMMdd = "yyyy-MM-dd";

    public static String getCurrStrDate(){
        SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
        return format.format(new Date());
    }

    public static int compare_date(String DATE1, String DATE2) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = df.parse(DATE1);
        Date dt2 = df.parse(DATE2);
        if (dt1.getTime() > dt2.getTime()) {
            System.out.println("dt1 在dt2前");
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            System.out.println("dt1在dt2后");
            return -1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) throws Exception{
        System.out.println(compare_date("2018-4-24","2018-4-24"));
    }

}
