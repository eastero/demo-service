package com.ty.demoservice.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        List<Room> roomList = Lists.newArrayList(
                new Room(11,23,56),
                new Room(11,84,48),
                new Room(22,46,112),
                new Room(22,75,62),
                new Room(22,56,75),
                new Room(33,92,224));
        Map<Integer,Long> countMap = roomList.stream()
                .collect(Collectors.groupingBy(Room::getHigh,Collectors.counting()));
        System.out.println("countMap："+countMap);
        Map<Integer,Integer> sumMap = roomList.stream().
                collect(Collectors.groupingBy(Room::getHigh,Collectors.summingInt(Room::getWidth)));
        System.out.println("sumMap："+sumMap);
        Map<Integer, Optional<Room>> maxMap = roomList.stream().
                collect(Collectors.groupingBy(Room::getHigh,
                        Collectors.maxBy(Comparator.comparing(Room::getWidth))
                ));
        System.out.println("maxMap:"+maxMap);
        Map<Integer, Optional<Integer>> collect = roomList.stream().collect(Collectors.groupingBy(Room::getHigh,
                Collectors.mapping(Room::getWidth,
                        Collectors.maxBy(Comparator.comparing(Integer::valueOf)))));
        System.out.println("collect:"+ JSON.toJSONString(collect));

        IntStream.range(0,roomList.size()).forEach(i->{
            System.out.println(i+"--->"+roomList.get(i));
        });
        roomList.stream().forEach(i-> System.out.println(i));
        System.out.println(111111111);
        int[] words = new int[23];
        Stream.of(roomList).parallel().forEach(s->{
            if(s.size()<10){
                System.out.println(s+"----"+System.currentTimeMillis());
                words[s.size()]++;
            }
        });
        System.out.println(words);

    }

}
