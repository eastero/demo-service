package com.ty.demoservice.test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class TestList {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList();
        int pageNumber = 1;
        int pageSize = 6;
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        myList.add(11);
        myList.add(12);
        myList.add(13);
        myList.add(14);
        myList.add(15);
        List<Integer> pageList = myList.stream()
                .skip((pageNumber-1)*pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        System.out.println(pageList);
        int sum = myList.stream().reduce(0,(total,y)->total+y.toString().length(),(total1,total2)->total1+total2);
        IntSummaryStatistics summaryStatistics = myList.stream().collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(summaryStatistics.hashCode());



    }

}
