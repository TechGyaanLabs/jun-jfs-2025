package com.careerit.jfs.cj.coursestats;

import com.careerit.jfs.cj.coursestats.service.CourseService;

public class CourseStatsManager {

    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        
        // Display course details with name, title, category, and fee
        courseService.showCourseDetails();

        // Display course stats with course id, title, category, total students, and total fees
        courseService.showCourseStats();
    }
} 