package com.careerit.jfs.cj.day28.cms;

import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Course> getAllCourses();
    List<Course> getActiveCourses();
    List<Course> getCoursesPriceBetween(double min, double max);
    List<String> getActiveCourseNames();
    Map<String, Double> getCoursePriceMap();
    Map<String,List<Course>> getCourseMapByCategory();
}
