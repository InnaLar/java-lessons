package org.example.hw5;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
public class MyCourse implements Course {
    private String course;

    @Override public String toString() {
        return course;
    }

}
