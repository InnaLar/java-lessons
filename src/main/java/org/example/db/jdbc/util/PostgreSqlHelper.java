package org.example.db.jdbc.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@UtilityClass
public class PostgreSqlHelper {
    private static final Connection CONNECTION = createConnection();

    private static Connection createConnection() {
        try {
            Properties properties = getCredentials();

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/storage", properties);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public static Connection getConnection() {
        return CONNECTION;
    }

    private static Properties getCredentials() {
        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "postgres");
        return properties;
    }

    public static void doMigrate() {
        Connection connection = PostgreSqlHelper.getConnection();
        try (Statement statement = connection.createStatement()) {
            String createFilesTableSql = """
                create table if not exists extension_refl
                (
                    id bigserial,
                    name varchar(10) not null,
                    constraint extension_pkey_id primary key (id)
                );
                """;
            statement.execute(createFilesTableSql);

            createFilesTableSql = """
                create table if not exists extension_refl
                (
                    id bigserial,
                    name varchar(100) not null,
                    type varchar(50),
                    url varchar(255) not null,
                    extension_id bigint not null,
                    constraint files_pkey_id primary key (id),
                    constraint files_fkey_extension_id foreign key (extension_id) references extension_refl(id)
                );
                """;
            statement.execute(createFilesTableSql);
            connection.commit();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
