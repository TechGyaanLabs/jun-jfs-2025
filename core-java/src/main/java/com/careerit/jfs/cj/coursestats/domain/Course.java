package com.careerit.jfs.cj.coursestats.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private String id;
    private String name;
    private String title;
    private String description;
    private double fee;
    private String category;
} 