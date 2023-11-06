package org.example.hw4_1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayStringGrouping {

    public static void main(final String[] args) {
        final String[] arrayString = new String[]{"red", "maroon", "red", "yellow", "maroon", "green", "maroon",
                "green", "white", "green", "maroon", "blue", "beige", "yellow", "black", "white"};
        stringGrouping(arrayString);
    }

    public static void stringGrouping(final String[] arr) {
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
