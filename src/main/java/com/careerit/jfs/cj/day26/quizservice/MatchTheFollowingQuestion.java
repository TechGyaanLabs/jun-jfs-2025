package com.careerit.jfs.cj.day26.quizservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchTheFollowingQuestion extends Question {
    private List<MPair> pairs;
    private List<MPair> answer;

    @Override
    public String getType() {
        return "MTF";
    }
}
