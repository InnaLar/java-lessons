package org.example.jdbc.mapper;

import org.example.jdbc.model.dto.FileRs;
import org.example.jdbc.model.entity.File;

public class FileMapper {
    public FileRs toFileRs(final File file) {
        return FileRs.builder()
            .uniqueId(file.getId())
            .fileName(file.getName())
            .type(file.getType().name())
            .url(file.getUrl())
            .ext(file.getExtension())
            .build();
    }
}
