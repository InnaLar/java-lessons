package org.example.hw7;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("PMD.SystemPrintln")
public class App {
    public static void main(final String[] args) {
        Stream<Integer> streamInt = Stream.of(1, 2, 3, 4);
        float avgFloat = streamInt.collect(Collectors.averagingInt(s -> s)).floatValue();
        System.out.println(avgFloat);

        Stream<String> streamString = Stream.of("cow", "rabbit", "snake", "cat", "crow", "horse", "goat");
        Map<Integer, List<String>> stringsByLength = streamString.collect(Collectors.groupingBy(String::length));
        for (Map.Entry<Integer, List<String>> item : stringsByLength.entrySet()) {

            System.out.println(item.getKey());
            for (String string : item.getValue()) {

                System.out.println(string);
            }
            System.out.println();
        }
    }

}
