package org.example.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.jdbc.dao.FileDao;
import org.example.jdbc.mapper.FileMapper;
import org.example.jdbc.model.dto.FileRs;

import java.util.List;

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
}
