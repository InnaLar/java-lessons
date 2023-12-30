package org.example.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.jdbc.dao.FileDao;
import org.example.jdbc.exception.ErrorCode;
import org.example.jdbc.exception.ServiceException;
import org.example.jdbc.mapper.FileMapper;
import org.example.jdbc.model.dto.FileRs;
import org.example.jdbc.model.dto.FileRsIns;
import org.example.jdbc.model.entity.File;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FileService {
    private final FileDao fileDao;
    private final FileMapper fileMapper;

    public List<FileRs> findAll() {
        return fileDao.findAll()
            .stream()
            .map(fileMapper::toFileRs)
            .toList();
    }

    public void save(final FileRsIns request) {
        final File file = fileMapper.toFile(request);
        if (file.getExtension()==null)
        {
            throw new ServiceException(ErrorCode.ERR_CODE_002, request.getExt());
        }
        fileDao.save(file);
        return;
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

    public void update(final FileRs request)
    {
        final File file = fileMapper.toFile(request);
        if (file.getExtension()==null)
        {
            throw new ServiceException(ErrorCode.ERR_CODE_002, request.getExt());
        }
        fileDao.update(file);
        return;
    }
}
