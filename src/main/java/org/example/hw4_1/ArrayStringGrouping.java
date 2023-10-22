package org.example.hw4_1;

import java.util.HashMap;
import java.util.Map;

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
        int countWord;
        for (String word : arr) {

            // todo: getOrDefault()
            //todo: putIfAbsent()
            /*countWord = hmStringGroup.getOrDefault(word, 0);
            countWord++;
            hmStringGroup.put(word, countWord);*/

            hmStringGroup.putIfAbsent(word, 0);
            countWord = hmStringGroup.get(word) + 1;
            hmStringGroup.put(word, countWord);
        }
        for (Map.Entry<String, Integer> entry : hmStringGroup.entrySet()) {
            System.out.println(entry.getKey() + " повторений = " + entry.getValue());
        }
    }
}
