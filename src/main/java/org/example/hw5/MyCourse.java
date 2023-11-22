package org.example.hw5;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class MyCourse implements Course {

    private Long id;
    private String course;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyCourse myCourse = (MyCourse) o;
        return Objects.equals(getId(), myCourse.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
