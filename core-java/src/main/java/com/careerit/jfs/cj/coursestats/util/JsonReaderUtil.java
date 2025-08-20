package com.careerit.jfs.cj.coursestats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.careerit.jfs.cj.coursestats.domain.Course;
import com.careerit.jfs.cj.coursestats.domain.Category;
import com.careerit.jfs.cj.coursestats.domain.Student;
import com.careerit.jfs.cj.coursestats.domain.StudentCourse;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class JsonReaderUtil {

    private JsonReaderUtil() {}

    /**
     * Generic method to load JSON data from a resource file
     * @param resourcePath The path to the JSON resource file
     * @param typeReference The TypeReference for the expected return type
     * @param <T> The type parameter
     * @return List of objects of type T, or empty list if error occurs
     */
    public static <T> List<T> loadJson(String resourcePath, TypeReference<List<T>> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = JsonReaderUtil.class
                    .getClassLoader().getResourceAsStream(resourcePath);
            if (inputStream != null) {
                return mapper.readValue(inputStream, typeReference);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * Generic method to load a single JSON object from a resource file
     * @param resourcePath The path to the JSON resource file
     * @param clazz The class of the expected return type
     * @param <T> The type parameter
     * @return Object of type T, or null if error occurs
     */
    public static <T> T loadJson(String resourcePath, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = JsonReaderUtil.class
                    .getClassLoader().getResourceAsStream(resourcePath);
            if (inputStream != null) {
                return mapper.readValue(inputStream, clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Convenience methods for specific data types
    public static List<Course> getCourses() {
        return loadJson("course_data/courses.json", new TypeReference<List<Course>>() {});
    }

    public static List<Category> getCategories() {
        return loadJson("course_data/categories.json", new TypeReference<List<Category>>() {});
    }

    public static List<Student> getStudents() {
        return loadJson("course_data/students.json", new TypeReference<List<Student>>() {});
    }

    public static List<StudentCourse> getStudentCourses() {
        return loadJson("course_data/student_courses.json", new TypeReference<List<StudentCourse>>() {});
    }
} 