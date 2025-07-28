package com.careerit.jfs.cj.day28.cms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
       return null;
    }

    @Override
    public List<Course> getCoursesPriceBetween(double min, double max) {
        return List.of();
    }

    @Override
    public List<String> getActiveCourseNames() {
        return List.of();
    }

    @Override
    public Map<String, Double> getCoursePriceMap() {
        return Map.of();
    }

    @Override
    public Map<String, List<Course>> getCourseMapByCategory() {
        return Map.of();
    }
}
