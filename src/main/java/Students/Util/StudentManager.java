package Students.Util;

import Students.Category;
import Students.Course;
import Students.Student;
import Students.StudentCourse;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<Course> courseList = JsonReaderUtil.getCourses();
        List<Student> studentList = JsonReaderUtil.getStudents();
        List<StudentCourse> studentCourseList = JsonReaderUtil.getStudentCourses();

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. View All Courses");
            System.out.println("2. View Students by Course Title");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    courseList.forEach(course ->
                            System.out.println(course.getTitle()));
                    break;

                case 2:
                    System.out.print("Enter course title: ");
                    String inputTitle = scanner.nextLine().trim();

                    List<Course> matchedCourses = new ArrayList<>();
                    for (Course c1 : courseList) {
                        if (c1.getTitle().equalsIgnoreCase(inputTitle)) {
                            matchedCourses.add(c1);
                        }
                    }

                    if (matchedCourses.isEmpty()) {
                        System.out.println("No course found with title: " + inputTitle);
                        break;
                    }

                    List<String> matchingCourseIds = matchedCourses.stream()
                            .map(Course::getId)
                            .toList();

                    List<StudentCourse> matchedStudentCourses = studentCourseList.stream()
                            .filter(sc -> {
                                return matchingCourseIds.contains(sc.getCourseId());
                            })
                            .toList();

                    if (matchedStudentCourses.isEmpty()) {
                        System.out.println("No students enrolled in course: " + inputTitle);
                        break;
                    }

                    System.out.println("Students in " + inputTitle + ":");

                    for (StudentCourse sc : matchedStudentCourses) {

                        Student student = studentList.stream()
                                .filter(s -> s.getId().equals(sc.getStudentId()))
                                .findFirst()
                                .orElse(null);

                        Course course = courseList.stream()
                                .filter(c -> c.getId().equals(sc.getCourseId()))
                                .findFirst()
                                .orElse(null);

                        if (student != null && course != null) {
                            System.out.println(student.getName() + " - " + student.getEmail() +
                                    " | Course: " + course.getTitle() +
                                    " | Fee: ₹" + course.getFee());
                        }
                    }
                    break;


                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
