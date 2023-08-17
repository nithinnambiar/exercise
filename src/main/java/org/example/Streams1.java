package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams1 {

    public void testNumberRangeOperations() {

        var intstream = IntStream.range(10, 30).filter( n -> n%2 == 1);
        intstream.forEach(System.out::println);
    }

    public void testNumberReduceOperations() {
        var stream = IntStream.range(1, 100);
        System.out.println(stream.reduce(0, (a, b) -> a+b));
    }

    public void testMapOperations() {
        var wordList = Arrays.asList("Orange", "Apple", "Bananas", "BlueBerry", "Pear");
        System.out.println(wordList.stream().map(String::length).collect(Collectors.toList()));

    }

    public void testDistinct() {
        var list = Arrays.asList(3, 1, 2, 3, 4, 6, 4, 7, 9, 7);
        list.stream().distinct().sorted().forEach(System.out::println);
    }

    public void testFilterAndComparison() {
        int number = 3;
        Map<Integer, String> map = Map.of(1, "I", 5, "V");

        int h = map.keySet().stream().sorted(Comparator.naturalOrder()).filter(n -> n > number).findFirst().get();
        int l = map.keySet().stream().sorted(Comparator.reverseOrder()).filter(n -> n < number).findFirst().get();

        int mid = (h + l)/2;
        if(number >= mid) {

        }
        System.out.println(h + ", " + l);

    }

    public static void main(String[] args) {
        Streams1 stream1 = new Streams1();
        //stream1.testNumberRangeOperations();
        //stream1.testNumberReduceOperations();
        //stream1.testMapOperations();
        //stream1.testDistinct();
        stream1.testFilterAndComparison();

    }
}
