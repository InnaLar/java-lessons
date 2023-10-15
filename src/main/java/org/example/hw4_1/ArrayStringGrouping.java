package org.example.hw4_1;

import java.util.HashMap;
import java.util.Map;

public class ArrayStringGrouping {
    public static void main(final String[] args) {
        final String[] arrayString = new String[]{"red", "maroon", "red", "yellow", "maroon", "green", "maroon", "green", "maroon", "green", "maroon", "green", "maroon", "green", "maroon", "green"};
        stringGrouping(arrayString);
    }

    public static void stringGrouping(final String[] arr) {
        final Map<String, Integer> hmStringGroup = new HashMap<>();
        int countWord = 1;
        for (String word: arr
             ) {
            if (hmStringGroup.containsKey(word)) {
                countWord = hmStringGroup.get(word);
                countWord++;
                hmStringGroup.put(word, countWord);
               } else {
                hmStringGroup.put(word, 1);
                }
               }
        for (Map.Entry<String, Integer> entry : hmStringGroup.entrySet()) {
            System.out.println(entry.getKey() + " повторений = " + entry.getValue());
        }
    }
}
