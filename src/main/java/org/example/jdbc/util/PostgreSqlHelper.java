package org.example.jdbc.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@UtilityClass
public class PostgreSqlHelper {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Properties properties = getCredentials();

                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/files", properties);
                conn.setAutoCommit(false);
                connection = conn;
            }

            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException(e);
        }

    }

    private static Properties getCredentials() {
        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "postgres");
        return properties;
    }

    public static void doMigrate() {
        Connection connection = PostgreSqlHelper.getConnection();

        try (final Statement statement = connection.createStatement()) {
            final String createFilesTableSql = """
                create table if not exists files
                (
                	id BIGSERIAL,
                	name varchar(100) not null,
                	type varchar(50),
                	url varchar(255) not null,
                	extension varchar(10),
                	constraint files_pkey_id primary key (id)
                );
                """;
            statement.execute(createFilesTableSql);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
