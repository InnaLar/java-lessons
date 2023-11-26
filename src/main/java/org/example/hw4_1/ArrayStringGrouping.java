package org.example.hw4_1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings({"PMD.SystemPrintln", "PMD.AvoidDuplicateLiterals", "SystemPrintln"})
public class ArrayStringGrouping {

    public static void main(final String[] args) {
        stringGrouping("red", "maroon", "red", "yellow", "maroon", "green", "maroon",
                "green", "white", "green", "maroon", "blue", "beige", "yellow", "black", "white");
    }

    public static void stringGrouping(final String... arr) {
        final Map<String, Integer> hmStringGroup = new ConcurrentHashMap<>();
        int countWord;
        for (String word : arr) {

            hmStringGroup.putIfAbsent(word, 0);
            countWord = hmStringGroup.get(word) + 1;
            hmStringGroup.put(word, countWord);
        }
        for (Map.Entry<String, Integer> entry : hmStringGroup.entrySet()) {
            System.out.println(entry.getKey() + " повторений = " + entry.getValue());
        }
    }
}
