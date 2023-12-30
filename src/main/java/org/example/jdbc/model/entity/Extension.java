package org.example.jdbc.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Extension {
    private Long id;
    private String name;
}
