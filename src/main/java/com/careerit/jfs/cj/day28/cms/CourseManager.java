package com.careerit.jfs.cj.day28.cms;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CourseManager {

    public static void main(String[] args) {


        CourseService courseService = new CourseServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Course Management System");
            System.out.println("-".repeat(150));
            System.out.println("1. View All Courses");
            System.out.println("2. View Courses by Category");
            System.out.println("3. View Course by Price Range");
            System.out.println("4. View Active Courses");
            System.out.println("5. View Active Course Names");
            System.out.println("6. View Course name and Price");
            System.out.println("7. View Courses sort by Price");
            System.out.println("8. Exit");
            System.out.println("-".repeat(150));
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Course> allCourses = courseService.getAllCourses();
                    showCourseDetails(allCourses, "No courses are added yet.... please add course");
                    break;
                case 2:
                    Map<String, List<Course>> courseMapByCategory = courseService.getCourseMapByCategory();
                    courseMapByCategory.forEach((category, courses) -> {
                        System.out.println("Category: " + category);
                        showCourseDetails(courses, "Category: " + category + " has no course");
                        System.out.println(".".repeat(100));
                    });
                    break;
                case 3:
                    System.out.println("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.println("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    String message = "No courses found in the price range " + minPrice + " to " + maxPrice;
                    List<Course> coursesByPriceRange = courseService.getCoursesPriceBetween(minPrice, maxPrice);
                    showCourseDetails(coursesByPriceRange, message);
                    break;
                case 4:
                    List<Course> activeCourses = courseService.getActiveCourses();
                    showCourseDetails(activeCourses, "No active courses found");
                    break;
                case 5:
                    List<String> activeCourseNames = courseService.getActiveCourseNames();
                    if (activeCourseNames.isEmpty()) {
                        System.out.println("No active course names found");
                    } else {
                        activeCourseNames.forEach(System.out::println);
                    }
                    break;
                case 6:
                    Map<String, Double> courseNamePriceMap = courseService.getCoursePriceMap();
                    courseNamePriceMap.forEach((courseName, price) -> {
                        System.out.println("Course Name: " + courseName);
                        System.out.println("Price: " + price);
                        System.out.println("-".repeat(50));
                    });
                    break;
                case 7:
                    List<Course> sortedCourses = courseService.getCoursesSortedByFee("desc");
                    showCourseDetails(sortedCourses, "No courses found");
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }

    public static void showCourseDetails(List<Course> courses, String message) {
        if (courses.isEmpty()) {
            System.out.println(message);
        } else {
            for (Course course : courses) {
                System.out.println("Course Name: " + course.getName());
                System.out.println("Title: " + course.getTitle());
                System.out.println("Description: " + course.getDescription());
                System.out.println("Category: " + course.getCategory());
                System.out.println("Fee: " + course.getFee());
                System.out.println("Status: " + course.getStatus());
                System.out.println("-".repeat(150));
            }
        }
    }
}
