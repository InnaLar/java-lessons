package org.example.jdbc.dao;

import org.example.hw6.dao.CrudRepository;
import org.example.jdbc.constant.SqlConstants;
import org.example.jdbc.model.entity.Extension;
import org.example.jdbc.util.PostgreSqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExtensionDao implements CrudRepository<Extension, Long> {

    private static Extension buildExtension(final ResultSet resultSet) throws SQLException {
        return Extension.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .build();
    }

    @Override
    public List<Extension> findAll() {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SqlConstants.SELECT_FROM_EXTENSION_REFL);

            List<Extension> extensionList = new ArrayList<>();
            while (resultSet.next()) {
                extensionList.add(buildExtension(resultSet));
            }

            return extensionList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<Extension> findById(Long id) {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SqlConstants.getStringSelectExtensionById(id));
            Extension extension = null;
            while (resultSet.next()) {
                extension = buildExtension(resultSet);
            }
            return Optional.ofNullable(extension);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Extension save(Extension user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        return;
    }

    @Override
    public Extension update(Extension user) {
        return null;
    }

    public Optional<Extension> findByName(final String name) {
        Connection connection = PostgreSqlHelper.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SqlConstants.SELECT_FROM_EXTENSION_REFL_WHERE_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(buildExtension(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
