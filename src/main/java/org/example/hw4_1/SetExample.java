package org.example.hw4_1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class SetExample {
    public static void main(String[] args) {
        User user = User.builder()
                .id(1)
                .name("1")
                .age(23)
                .build();
        HashMap<User, String> hashMap = new HashMap<>();

        hashMap.put(user, "hello world");

        user.age = 21;

        System.out.println(hashMap.get(user));
    }
}


@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
class User {
    int id;
    int age;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
