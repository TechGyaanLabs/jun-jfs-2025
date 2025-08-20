package com.careerit.jfs.cj.coursestats.service;

import com.careerit.jfs.cj.coursestats.domain.Category;
import com.careerit.jfs.cj.coursestats.domain.Course;
import com.careerit.jfs.cj.coursestats.domain.Student;
import com.careerit.jfs.cj.coursestats.domain.StudentCourse;
import com.careerit.jfs.cj.coursestats.dto.CourseDetailRecord;
import com.careerit.jfs.cj.coursestats.dto.CourseStats;
import com.careerit.jfs.cj.coursestats.util.JsonReaderUtil;

import java.util.*;
import java.util.stream.Collectors;

public class CourseService {

    private final Map<String, Course> courseMap;
    private final Map<String, Category> categoryMap;
    private final Map<String, Student> studentMap;
    private final List<StudentCourse> studentCourses;
    private final Map<String, Long> courseStudentCountMap;

    public CourseService() {
        // Load all data
        List<Course> courses = JsonReaderUtil.getCourses();
        List<Category> categories = JsonReaderUtil.getCategories();
        List<Student> students = JsonReaderUtil.getStudents();
        studentCourses = JsonReaderUtil.getStudentCourses();
        
        // Create maps for O(1) lookups
        this.courseMap = courses.stream()
                .collect(Collectors.toMap(Course::getId, course -> course));
        this.categoryMap = categories.stream()
                .collect(Collectors.toMap(Category::getId, category -> category));
        this.studentMap = students.stream()
                .collect(Collectors.toMap(Student::getId, student -> student));
        this.courseStudentCountMap = studentCourses.stream()
                .collect(Collectors.groupingBy(StudentCourse::getCourseId, Collectors.counting()));
    }

    /**
     * Display course statistics including course ID, title, category, student count, and total fees
     */
    public void showCourseStats() {
        List<CourseStats> courseStats = generateCourseStats();
        printCourseStatsHeader();
        courseStats.forEach(this::printCourseStat);
        printCourseStatsFooter(courseStats.size());
    }

    /**
     * Display detailed course enrollment information
     */
    public void showCourseDetails() {
        printCourseDetailsHeader();
        
        studentCourses.stream()
                .map(this::createCourseDetail)
                .filter(Objects::nonNull)
                .forEach(this::printCourseDetail);
        
        printCourseDetailsFooter();
    }

    // Private helper methods

    private List<CourseStats> generateCourseStats() {
        return courseMap.values().stream()
                .map(this::createCourseStat)
                .sorted(Comparator.comparing(CourseStats::totalAmount).reversed()
                        .thenComparing(CourseStats::title))
                .collect(Collectors.toList());
    }

    private CourseStats createCourseStat(Course course) {
        long studentCount = courseStudentCountMap.getOrDefault(course.getId(), 0L);
        double totalAmount = studentCount * course.getFee();
        String categoryName = getCategoryName(course.getCategory());
        
        return new CourseStats(
                course.getId(), 
                course.getTitle(), 
                categoryName, 
                studentCount, 
                totalAmount
        );
    }

    private CourseDetailRecord createCourseDetail(StudentCourse studentCourse) {
        Student student = studentMap.get(studentCourse.getStudentId());
        Course course = courseMap.get(studentCourse.getCourseId());
        
        if (student == null || course == null) {
            return null;
        }
        
        String categoryName = getCategoryName(course.getCategory());
        return new CourseDetailRecord(
                student.getName(), 
                course.getTitle(), 
                categoryName, 
                course.getFee()
        );
    }

    private String getCategoryName(String categoryId) {
        Category category = categoryMap.get(categoryId);
        return category != null ? category.getName() : "Unknown";
    }

    // Print methods

    private void printCourseStatsHeader() {
        String header = "Course Statistics";
        int padding = (110 - header.length()) / 2;
        System.out.println("=".repeat(110));
        System.out.println(" ".repeat(padding) + header + " ".repeat(padding));
        System.out.println("=".repeat(110));
        System.out.printf("%-20s %-40s %-20s %-15s %-15s%n", 
                "Course ID", "Course Title", "Category", "Total Students", "Total Fees");
        System.out.println("-".repeat(110));
    }

    private void printCourseStat(CourseStats courseStat) {
        System.out.printf("%-20s %-40s %-20s %-15d $%-14.2f%n", 
                courseStat.id(), 
                courseStat.title(), 
                courseStat.category(), 
                courseStat.studentsCount(), 
                courseStat.totalAmount());
    }

    private void printCourseStatsFooter(int totalCourses) {
        System.out.println("-".repeat(110));
        System.out.println("Total Courses: " + totalCourses);
    }

    private void printCourseDetailsHeader() {
        String header = "Course Details";
        int padding = (90 - header.length()) / 2;
        System.out.println("-".repeat(90));
        System.out.println(" ".repeat(padding) + header + " ".repeat(padding));
        System.out.println("-".repeat(90));
        System.out.printf("%-20s %-40s %-20s %-10s%n", 
                "Student Name", "Course Title", "Category", "Fee");
        System.out.println("=".repeat(90));
    }

    private void printCourseDetail(CourseDetailRecord detail) {
        System.out.printf("%-20s %-40s %-20s $%-9.2f%n",
                detail.studentName(),
                detail.courseTitle(),
                detail.categoryName(),
                detail.fee());
    }

    private void printCourseDetailsFooter() {
        System.out.println("-".repeat(90));
        System.out.println("Total Enrollments: " + studentCourses.size());
    }

    // Getter methods for external access
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categoryMap.values());
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }
}