package org.example.jdbc;

import org.example.jdbc.dao.FileDao;
import org.example.jdbc.mapper.FileMapper;
import org.example.jdbc.model.dto.FileRs;
import org.example.jdbc.service.FileService;
import org.example.jdbc.util.PostgreSqlHelper;

import java.util.List;

public class PostgreSQLJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            PostgreSqlHelper.doMigrate();

            FileDao fileDao = new FileDao();
            FileMapper fileMapper = new FileMapper();
            FileService fileService = new FileService(fileDao, fileMapper);

            List<FileRs> files = fileService.findAll();
            files.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
