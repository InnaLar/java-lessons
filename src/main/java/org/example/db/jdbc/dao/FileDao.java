package org.example.db.jdbc.dao;

import org.example.db.jdbc.constant.SqlConstants;
import org.example.db.jdbc.model.dto.enums.Type;
import org.example.db.jdbc.model.entity.File;
import org.example.db.jdbc.util.PostgreSqlHelper;
import org.example.hw6.dao.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            .extensionId(resultSet.getLong("extension"))
            .build();
    }

    @Override
    public List<File> findAll() {
        try (Connection connection = PostgreSqlHelper.getConnection();
            Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlConstants.SELECT_FROM_FILES)) {

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
        try (Connection connection = PostgreSqlHelper.getConnection();
            PreparedStatement statement =
                 connection.prepareStatement(SqlConstants.SELECT_FROM_FILES_WHERE_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.ofNullable(buildFile(resultSet));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public File save(final File t) {
        try (Connection connection = PostgreSqlHelper.getConnection();
            PreparedStatement statement =
                 connection.prepareStatement(SqlConstants.INSERT_INTO_FILES_NAME_TYPE_URL_EXTENSION_VALUES_S_S_S_D,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, t.getName());
            statement.setString(2, t.getType().name());
            statement.setString(3, t.getUrl());
            statement.setLong(4, t.getExtensionId());
            statement.executeUpdate();
            connection.commit();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                keys.next();
                t.setId(keys.getLong(1));
                return t;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteById(final Long id) {
        try (Connection connection = PostgreSqlHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConstants.GET_DELETE_FILE_BY_ID)) {
            statement.setLong(1, id);
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public File update(final File t) {
        try (Connection connection = PostgreSqlHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConstants.GET_UPDATE_FILES_BY_ID_WITH_VALUES)) {
            statement.setString(1, t.getName());
            statement.setString(2, String.valueOf(t.getType()));
            statement.setString(3, t.getUrl());
            statement.setLong(4, t.getExtensionId());
            statement.setLong(5, t.getId());
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return t;
    }

}
