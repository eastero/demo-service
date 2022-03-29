package com.ty.demoservice.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TestString {

private static final Logger logger = LoggerFactory.getLogger(TestString.class);
    //private static final Logger logger = LoggerFactory.getLogger(TestString.class);
    String s1;
    Integer i1;
    Date dt;
    double d1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestString that = (TestString) o;
        return s1.equals(that.s1) &&
                i1.equals(that.i1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s1, i1);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestString{");
        sb.append("s1='").append(s1).append('\'');
        sb.append(", s2=").append(i1);
        sb.append('}');
        return sb.toString();
    }
    public static void main(String[] args) {
        TestString testString = new TestString();
        String a = "a";//a
        String b = "b";//b
        String c = "c";//c
        String d = "d";//d
        String e = "e";//e
        String f = "f";//f
        int g = 1000;


        String currentTime2 = getCurrentTime2();
        System.out.println(System.currentTimeMillis());
        logger.info("Current Time------->"+currentTime2);
    }


    //todo
    private static void getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
    }
    //todo
    private static String getCurrentTime2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String s = sdf.format(date);
        System.out.println(s);
        return s;
    }



}

