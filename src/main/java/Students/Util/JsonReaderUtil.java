package Students.Util;

import Students.Category;
import Students.Course;
import Students.Student;
import Students.StudentCourse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.InputStream;
import java.util.List;

public class JsonReaderUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Category> getCategories() throws Exception {
        InputStream is = JsonReaderUtil.class.getResourceAsStream("/course_data/categories.json");
        return mapper.readValue(is, new TypeReference<>() {
        });
    }

    public static List<Course> getCourses() throws Exception {
        InputStream is = JsonReaderUtil.class.getResourceAsStream("/course_data/courses.json");
        return mapper.readValue(is, new TypeReference<>() {
        });
    }

    public static List<Student> getStudents() throws Exception {
        InputStream is = JsonReaderUtil.class.getResourceAsStream("/course_data/students.json");
        return mapper.readValue(is, new TypeReference<>() {
        });
    }

    public static List<StudentCourse> getStudentCourses() throws Exception {
        InputStream is = JsonReaderUtil.class.getResourceAsStream("/course_data/student_courses.json");
        return mapper.readValue(is, new TypeReference<>() {
        });
    }
}
