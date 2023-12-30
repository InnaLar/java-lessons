package org.example.jdbc.model.entity;

import lombok.Builder;
import lombok.Data;
import org.example.jdbc.model.dto.enums.Type;

import java.util.Objects;

@Data
@Builder
public class File {
    private Long id;
    private String name;
    private Type type;
    private String url;
    private Long extension;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        File file = (File) o;
        return Objects.equals(id, file.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
