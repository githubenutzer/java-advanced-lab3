package labs.kpi.validators;

import labs.kpi.annotations.*;
import java.lang.reflect.Field;


/**
 * Utility class for validating objects.
 *
 * @author Oleksii Kyrychenko
 */
public class Validator {

    /**
     * Validates the fields of the given object according to the annotations.
     * Throws IllegalArgumentException if any constraint is violated.
     *
     * @param obj the object to be validated
     */
    public static void validate(Object obj) {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to access field: " + field.getName(), e);
            }

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                throw new IllegalArgumentException("Field '" + field.getName() + "' cannot be null.");
            }

            if (field.isAnnotationPresent(StringLength.class)) {
                if (!(value instanceof String)) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be a String for @StringLength.");
                }
                String strValue = (String) value;
                StringLength annotation = field.getAnnotation(StringLength.class);
                if (strValue.length() < annotation.min() || strValue.length() > annotation.max()) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' length must be between " + annotation.min() + " and " + annotation.max() + ".");
                }
            }

            if (field.isAnnotationPresent(MinValue.class)) {
                if (!(value instanceof Integer)) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be an Integer for @MinValue.");
                }
                int intValue = (int) value;
                MinValue annotation = field.getAnnotation(MinValue.class);
                if (intValue < annotation.value()) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be >= " + annotation.value() + ".");
                }
            }

            if (field.isAnnotationPresent(MaxValue.class)) {
                if (!(value instanceof Integer)) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be an Integer for @MaxValue.");
                }
                int intValue = (int) value;
                MaxValue annotation = field.getAnnotation(MaxValue.class);
                if (intValue > annotation.value()) {
                    throw new IllegalArgumentException("Field '" + field.getName() + "' must be <= " + annotation.value() + ".");
                }
            }
        }
    }
}