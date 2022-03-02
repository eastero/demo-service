package com.ty.demoservice.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        try {
            Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN)).limit(10);
            BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
            System.out.println(Arrays.toString(bigIntArr));

            if (true) {
                throw  new Exception("1111");
            }
            System.out.println(1234567890);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
