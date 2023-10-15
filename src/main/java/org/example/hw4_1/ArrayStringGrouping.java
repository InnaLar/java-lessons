package org.example.hw4_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayStringGrouping {
    public static void main(final String[] args) {
        final String[] arrayString = new String[]{"red", "maroon", "red", "yellow", "maroon", "green", "maroon",
                "green", "maroon", "green", "maroon", "green", "maroon", "green", "maroon", "green"};
        stringGrouping(arrayString);
    }

    //FlyableRunable

    //Bird impl FlyableRunable
    //run -> throw new NotImpl();
    public static void stringGrouping(final String[] arr) {
        final Map<String, Integer> hmStringGroup = new HashMap<>();
        int countWord = 1;
        for (String word : arr) {

            // todo: getOrDefault()
            //todo: putIfAbsent()
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
