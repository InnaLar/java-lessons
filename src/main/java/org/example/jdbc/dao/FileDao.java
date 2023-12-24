package org.example.jdbc.dao;

import org.example.hw6.dao.CrudRepository;
import org.example.jdbc.constant.SqlConstants;
import org.example.jdbc.model.dto.enums.Type;
import org.example.jdbc.model.entity.File;
import org.example.jdbc.util.PostgreSqlHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileDao implements CrudRepository<File, Long> {

    private static File buildFile(final ResultSet resultSet) throws SQLException {
        return File.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .type(Type.valueOf(resultSet.getString("type")))
            .url(resultSet.getString("url"))
            .extension(resultSet.getString("extension"))
            .build();
    }

    @Override
    public List<File> findAll() {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SqlConstants.SELECT_FROM_FILES);

            List<File> fileList = new ArrayList<>();
            while (resultSet.next()) {
                fileList.add(buildFile(resultSet));
            }

            return fileList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<File> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public File save(File user) {
        //            String insertIntoFilesSql = """
//                insert into files (name, type, url, extension)
//                values ('example_file_name10.txt', 'personal', 'local/files/example_file_name10.txt', 'txt');
//                """;
//            statement.execute(insertIntoFilesSql);
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public File update(File user) {
        return null;
    }
}
