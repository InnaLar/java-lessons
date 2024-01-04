package org.example.db.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.db.jdbc.dao.ExtensionDao;
import org.example.db.jdbc.dao.FileDao;
import org.example.db.jdbc.exception.ErrorCode;
import org.example.db.jdbc.exception.ServiceException;
import org.example.db.jdbc.mapper.FileMapper;
import org.example.db.jdbc.model.dto.FileRs;
import org.example.db.jdbc.model.dto.FileRsIns;
import org.example.db.jdbc.model.entity.Extension;
import org.example.db.jdbc.model.entity.File;

import java.util.List;

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
        return fileDao.findById(id)
            .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_001, id));
    }

    public void update(final FileRs request) {
        Extension extension = extensionDao.findByName(request.getExt())
            .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_002, request.getExt()));
        final File file = fileMapper.toFile(request, extension);
        fileDao.update(file);
    }
}
