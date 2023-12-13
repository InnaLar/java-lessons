package org.example.http.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class OutdoorConditions {
    private String name;
    private int value;
    private String category;

    public String toString() {
        return String.format("%s value %d %s", name, value, category);
    }
}
