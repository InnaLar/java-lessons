package org.example.jdbc.mapper;

import lombok.RequiredArgsConstructor;
import org.example.jdbc.dao.ExtensionDao;
import org.example.jdbc.model.dto.FileRs;
import org.example.jdbc.model.dto.FileRsIns;
import org.example.jdbc.model.dto.enums.Type;
import org.example.jdbc.model.entity.Extension;
import org.example.jdbc.model.entity.File;

import java.util.Optional;

@RequiredArgsConstructor
public class FileMapper {
    private final ExtensionDao extensionDao;
    public FileRs toFileRs(final File file) {
        Optional<Extension> extension = extensionDao.findById(file.getExtension());
        return FileRs.builder()
            .uniqueId(file.getId())
            .fileName(file.getName())
            .type(file.getType().name())
            .url(file.getUrl())
            .ext(String.valueOf(extension))
            .build();
    }

    public File toFile(final FileRsIns request) {
        Optional<Extension> extensionFound = extensionDao.findAll()
            .stream()
            .filter(extension -> extension.getName().equals(request.getExt()))
            .findFirst();
        Long idExtension = extensionFound.map(Extension::getId).orElse(null);
        return File.builder()
            .id(0L)
            .name(request.getFileName())
            .type(Type.valueOf(request.getType()))
            .url(request.getUrl())
            .extension(idExtension)
            .build();
    }

    public File toFile(final FileRs request) {
        Optional<Extension> extensionFound = extensionDao.findAll()
            .stream()
            .filter(extension -> extension.getName().equals(request.getExt()))
            .findFirst();
        Long idExtension = extensionFound.map(Extension::getId).orElse(null);
        return File.builder()
            .id(request.getUniqueId())
            .name(request.getFileName())
            .type(Type.valueOf(request.getType()))
            .url(request.getUrl())
            .extension(idExtension)
            .build();
    }
}
