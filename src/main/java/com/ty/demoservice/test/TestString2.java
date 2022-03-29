package com.ty.demoservice.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TestString2 {
    String s1;
    Integer i1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestString2 that = (TestString2) o;
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
        String a = "a";//a
        String b = "b";//b
        String c = "c";//c
        String d = "d";//d
        String e = "e";//e

        getCurrentTime();
        System.out.println(System.currentTimeMillis());

    }

    private static void getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
    }


}

