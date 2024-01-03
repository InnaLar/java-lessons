package org.example.jdbc.constant;

import lombok.experimental.UtilityClass;
import org.example.jdbc.model.dto.enums.Type;

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

    public static String getStringSelectFileById(final Long id) {
        return String.format("select * from files where id = %d", id);
    }

    public static String getStringDeleteFileById(final Long id) {
        return String.format("""
            delete from files where id = %s;
            commit;
            """, id);
    }

    public static String getStringUpdateFileByIdWithValues(final Long id, final String name, final Type type, final String url, final Long extension) {
        String str = String.format("""
            update files
            set name = '%s',
                type = '%s',
                url = '%s',
                extension_id = %d
            where id = % d;
            commit;
            """, name, Type.valueOf(String.valueOf(type)), url, extension, id);
        return str;
    }

    public static String getStringSelectExtensionById(final Long id) {
        return String.format("select * from extension_refl where id = %d", id);
    }
}
