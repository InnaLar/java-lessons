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
            .extension(resultSet.getLong("extension"))
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
    public Optional<File> findById(final Long id) {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SqlConstants.getStringSelectFileById(id));
            /*return Optional.ofNullable(buildFile(resultSet));*/
            File file = null;
            while (resultSet.next()) {
                file = buildFile(resultSet);
            }
            return Optional.ofNullable(file);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public File save(final File user) {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            if (statement.execute(SqlConstants.getStringInsertFileWithValues(user.getName(),
                user.getType(),
                user.getUrl(),
                user.getExtension()))) {
                return user; }
            else {
                return null; }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void deleteById(final Long id) {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(SqlConstants.getStringDeleteFileById(id));
            return;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public File update(final File user) {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            if (statement.execute(SqlConstants.getStringUpdateFileByIdWithValues(user.getId(),
                user.getName(),
                user.getType(),
                user.getUrl(),
                user.getExtension()))) {
            return user; }
            else { return null;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
