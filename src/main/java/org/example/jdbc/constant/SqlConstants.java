package org.example.jdbc.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SqlConstants {
    public static final String SELECT_FROM_FILES = """
            select * from files
        """;

    public static final String SELECT_FROM_EXTENSION_REFL = """
            select * from extension_refl
        """;
    public static final String SELECT_FROM_EXTENSION_REFL_WHERE_NAME = """
        select * from extension_refl where name = ?
        """;

    public static final String INSERT_INTO_FILES_NAME_TYPE_URL_EXTENSION_VALUES_S_S_S_D = """
        insert into files (name, type, url, extension_id) values (?, ?, ?, ?);
        """;

    public static final String SELECT_FROM_FILES_WHERE_ID = """
        select * from files where id = ?
        """;

    public static final String GET_DELETE_FILE_BY_ID = """
        delete from files where id = ?;
        """;

    public static final String GET_UPDATE_FILES_BY_ID_WITH_VALUES = """
        update files
            set name = ?,
                type = ?,
                url = ?,
                extension_id = ?
            where id = ?;
        """;

    public static final String GET_SELECT_EXTENSION_BY_ID = """
        select * from extension_refl where id = ?
        """;

}
