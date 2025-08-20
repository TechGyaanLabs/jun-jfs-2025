package com.careerit.jfs.cj.day26.quizservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class McqQuestion extends Question {
    private List<String> options;
    private String answer;

    @Override
    public String getType() {
        return "MCQ";
    }
}
