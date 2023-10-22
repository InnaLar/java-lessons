package org.example.hw4_1;

import java.util.HashMap;
import java.util.Map;

public class SetExample {

    public static void main(final String[] args) {
        User user = User.builder()
                .id(1)
                .name("1")
                .age(23)
                .build();
        Map<User, String> hashMap = new HashMap<>();

        hashMap.put(user, "hello world");

        user.age = 21;

        System.out.println(hashMap.get(user));
    }
}


