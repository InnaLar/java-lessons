package org.example.hw6.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Long id;
    private String lastName;
    private String phoneNumber;

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, phoneNumber);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;

        return Long.compare(id, user.id) == 0
            && lastName.equals(user.lastName)
            && phoneNumber.equals(user.phoneNumber);
    }
}

