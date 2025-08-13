package com.careerit.jfs.cj.optinal;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.Map;

public class ConvertorUtil {


    public static <T> T convertUsingObjectMapper(Map<String, Object> map, Class<T> targetClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.convertValue(map, targetClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Map to " + targetClass.getSimpleName(), e);
        }
    }


    /**
     * Converts a Map to an object of the specified class using reflection
     * @param map The map containing field names and values
     * @param targetClass The target class to convert to
     * @param <T> The type parameter
     * @return An instance of the target class, or null if conversion fails
     */
    public static <T> T convert(Map<String, Object> map, Class<T> targetClass) {
        try {
            // Get all declared fields from the target class
            Field[] fields = targetClass.getDeclaredFields();
            
            // Create a new instance of the target class
            T obj = targetClass.getDeclaredConstructor().newInstance();
            
            // Iterate through each field and set its value
            for (Field field : fields) {
                String fieldName = field.getName();
                Object value = map.get(fieldName);
                if (value != null) {
                    field.setAccessible(true);
                    // Handle type conversion for common cases
                    Object convertedValue = convertValue(value, field.getType());
                    field.set(obj, convertedValue);
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Map to " + targetClass.getSimpleName(), e);
        }
    }
    
    /**
     * Converts a value to the target type if possible
     * @param value The value to convert
     * @param targetType The target type
     * @return The converted value
     */
    private static Object convertValue(Object value, Class<?> targetType) {
        if (value == null) {
            return null;
        }
        
        // If types match, return as is
        if (targetType.isAssignableFrom(value.getClass())) {
            return value;
        }
        
        // Handle common type conversions
        try {
            if (targetType == String.class) {
                return value.toString();
            } else if (targetType == Integer.class || targetType == int.class) {
                if (value instanceof Number) {
                    return ((Number) value).intValue();
                } else if (value instanceof String) {
                    return Integer.parseInt((String) value);
                }
            } else if (targetType == Long.class || targetType == long.class) {
                if (value instanceof Number) {
                    return ((Number) value).longValue();
                } else if (value instanceof String) {
                    return Long.parseLong((String) value);
                }
            } else if (targetType == Double.class || targetType == double.class) {
                if (value instanceof Number) {
                    return ((Number) value).doubleValue();
                } else if (value instanceof String) {
                    return Double.parseDouble((String) value);
                }
            } else if (targetType == Boolean.class || targetType == boolean.class) {
                if (value instanceof Boolean) {
                    return value;
                } else if (value instanceof String) {
                    return Boolean.parseBoolean((String) value);
                } else if (value instanceof Number) {
                    return ((Number) value).intValue() != 0;
                }
            }
        } catch (NumberFormatException e) {
            // If conversion fails, return the original value
            return value;
        }
        
        // Return original value if no conversion possible
        return value;
    }
}
