package org.example.hw4_1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SetExample {

    public static void main(final String[] args) {
        User user = User.builder()
                .id(1)
                .name("1")
                .age(23)
                .build();

        Map<User, String> hashMap = new ConcurrentHashMap<>();

        hashMap.put(user, "hello world");

        user.age = 21;

        String word = hashMap.getOrDefault(user, "не нашел такого пользователя");

        hashMap.put(user, word);

    }
}


