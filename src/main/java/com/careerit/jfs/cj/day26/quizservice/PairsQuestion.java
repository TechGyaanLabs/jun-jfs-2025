package com.careerit.jfs.cj.day26.quizservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PairsQuestion extends Question {
        private List<Pairs> pairs;
        private List<Pairs> answer;

        @Override
        public String getType() {
                return "Pairs";
        }
}
