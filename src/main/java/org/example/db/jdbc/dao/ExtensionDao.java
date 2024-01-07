package org.example.db.jdbc.dao;

import org.example.db.jdbc.constant.SqlConstants;
import org.example.db.jdbc.model.entity.Extension;
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

public class ExtensionDao implements CrudRepository<Extension, Long> {

    private static Extension buildExtension(final ResultSet resultSet) throws SQLException {
        return Extension.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .build();
    }

    @Override
    public List<Extension> findAll() {
        try (Connection connection = PostgreSqlHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlConstants.SELECT_FROM_EXTENSION_REFL)) {

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
    public Optional<Extension> findById(final Long id) {
        try (Connection connection = PostgreSqlHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlConstants.GET_SELECT_EXTENSION_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return Optional.ofNullable(buildExtension(resultSet));
            }
            return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Extension save(final Extension user) {
        // won't be implemented
        return null;
    }

    @Override
    public void deleteById(final Long id) {
        // won't be implemented
    }

    @Override
    public Extension update(final Extension user) {
        // won't be implemented
        return null;
    }

    public Optional<Extension> findByName(final String name) {
        try (Connection connection = PostgreSqlHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlConstants.SELECT_FROM_EXTENSION_REFL_WHERE_NAME)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return Optional.ofNullable(buildExtension(resultSet));
            }
            return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
