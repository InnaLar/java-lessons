package org.example.jdbc;

import org.example.jdbc.dao.ExtensionDao;
import org.example.jdbc.dao.FileDao;
import org.example.jdbc.mapper.FileMapper;
import org.example.jdbc.model.dto.FileRs;
import org.example.jdbc.model.dto.FileRsIns;
import org.example.jdbc.service.FileService;
import org.example.jdbc.util.PostgreSqlHelper;

import java.sql.SQLException;
import java.util.List;

public class PostgreSQLJDBC {
    public static void main(final String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            PostgreSqlHelper.doMigrate();

            FileDao fileDao = new FileDao();
            ExtensionDao extensionDao = new ExtensionDao();
            FileMapper fileMapper = new FileMapper(extensionDao);
            FileService fileService = new FileService(fileDao, fileMapper);
            FileRsIns request =
                FileRsIns.builder()
                    .fileName("apples")
                    .type("EDUCATION")
                    .url("https://lkfl2.nalog.ru/lkfl")
                    .ext("colobok")
                    .build();
            fileService.save(request);
            FileRs requestUpd =
                FileRs.builder()
                    .uniqueId(2L)
                    .fileName("oranges")
                    .type("PERSONAL")
                    .url("http://localhost/browser/")
                    .ext("zip")
                    .build();
            fileService.update(requestUpd);
            fileService.deleteById(10L);
            System.out.println(fileService.findById(2L));
            List<FileRs> files = fileService.findAll();
            files.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
