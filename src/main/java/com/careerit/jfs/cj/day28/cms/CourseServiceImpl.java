package com.careerit.jfs.cj.day28.cms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {

    private List<Course> courses = new ArrayList<>();

    public CourseServiceImpl() {
        courses = JsonReaderUtil.getCourses();
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public List<Course> getActiveCourses() {
       return courses.stream()
               .filter(course -> "Active".equalsIgnoreCase(course.getStatus()))
               .collect(Collectors.toList());
    }

    @Override
    public List<Course> getCoursesPriceBetween(double min, double max) {
        return courses.stream()
                .filter(course -> course.getFee() >= min && course.getFee() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getActiveCourseNames() {
        return courses.stream()
                .filter(course -> "Active".equalsIgnoreCase(course.getStatus()))
                .map(Course::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> getCoursePriceMap() {
        return courses.stream()
                .collect(Collectors.toMap(Course :: getName ,  Course::getFee));
    }

    @Override
    public Map<String, List<Course>> getCourseMapByCategory() {
        return courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory));
    }
}
