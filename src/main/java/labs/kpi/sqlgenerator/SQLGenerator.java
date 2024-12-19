package labs.kpi.sqlgenerator;

import java.lang.reflect.Field;

/**
 * Utility class for generating SQL CREATE TABLE statements based on class fields.
 *
 * @author Oleksii Kyrychenko
 */
public class SQLGenerator {

    /**
     * Generates a SQL CREATE TABLE statement based on the given class.
     * Supports fields of type String and int/Integer.
     *
     * @param clazz the class for which to generate the SQL
     * @return the SQL CREATE TABLE statement
     */
    public static String generateSQL(Class<?> clazz) {
        StringBuilder sql = new StringBuilder("CREATE TABLE ");
        sql.append(clazz.getSimpleName().toLowerCase()).append(" (");

        for (Field field : clazz.getDeclaredFields()) {
            sql.append(field.getName()).append(" ");
            if (field.getType() == String.class) {
                sql.append("VARCHAR(255)");
            } else if (field.getType() == int.class || field.getType() == Integer.class) {
                sql.append("INT");
            } else {
                throw new IllegalArgumentException("Unsupported field type: " + field.getType().getSimpleName());
            }
            sql.append(", ");
        }

        sql.delete(sql.length() - 2, sql.length());
        sql.append(");");

        return sql.toString();
    }
}
