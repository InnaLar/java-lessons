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

    public static String getStringSelectFileById(final Long id) {
        return String.format("select * from files where id = %d", id);
    }

    public static String getStringInsertFileWithValues(final String name, final Type type, final String url, final Long extension) {
        return String.format("""
            insert into files (name, type, url, extension) values ('%s', '%s', '%s', %d);
            commit;
            """, name, Type.valueOf(String.valueOf(type)), url, extension);

    }

    public static String getStringDeleteFileById(final Long id) {
        return String.format("""
            delete from files where id = %s;
            commit;
            """, id);
    }

    public static String getStringUpdateFileByIdWithValues(final Long id, final String name, final Type type, final String url, final Long extension) {
        String str = String.format("""
             update files\s
             set name = '%s',\s
                 type = '%s',\s
                 url = '%s',\s
                 extension = %d
             where id = % d;
             commit;
             """, name, Type.valueOf(String.valueOf(type)), url, extension, id);
        return str;
    }

    public static String getStringSelectExtensionById(final Long id) {
        return String.format("select * from extension_refl where id = %d", id);
    }
}
