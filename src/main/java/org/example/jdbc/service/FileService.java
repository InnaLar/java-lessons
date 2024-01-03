package org.example.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.jdbc.dao.ExtensionDao;
import org.example.jdbc.dao.FileDao;
import org.example.jdbc.exception.ErrorCode;
import org.example.jdbc.exception.ServiceException;
import org.example.jdbc.mapper.FileMapper;
import org.example.jdbc.model.dto.FileRs;
import org.example.jdbc.model.dto.FileRsIns;
import org.example.jdbc.model.entity.Extension;
import org.example.jdbc.model.entity.File;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FileService {
    private final FileDao fileDao;
    private final FileMapper fileMapper;
    private final ExtensionDao extensionDao;

    public List<FileRs> findAll() {
        return fileDao.findAll()
            .stream()
            .map(file -> {
                Extension extension = extensionDao.findById(file.getExtensionId())
                    .orElseThrow();
                return fileMapper.toFileRs(file, extension);
            })
            .toList();
    }

    public File save(final FileRsIns request) {
        Extension extension = extensionDao.findByName(request.getExt())
            .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_002, request.getExt()));

        final File file = fileMapper.toFile(request, extension);
        return fileDao.save(file);
    }

    public void deleteById(final Long id) {
        fileDao.deleteById(id);
    }

    public File findById(final Long id) {
        Optional<File> file = fileDao.findById(id);
        if (file.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_001, id);
        }
        return file.get();
    }

    public void update(final FileRs request) {
        final File file = fileMapper.toFile(request);
        if (file.getExtensionId() == null) {
            throw new ServiceException(ErrorCode.ERR_CODE_002, request.getExt());
        }
        fileDao.update(file);
        return;
    }
}
