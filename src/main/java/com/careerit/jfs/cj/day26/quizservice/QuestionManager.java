package com.careerit.jfs.cj.day26.quizservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionManager {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = QuestionManager.class.getClassLoader()
                .getResourceAsStream("questions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questions = objectMapper.readValue(inputStream,
             new TypeReference<List<Question>>() {});
        System.out.println("Total number of questions: " + questions.size());

        for (Question question : questions) {
            if(question instanceof McqQuestion mcq){
                System.out.println(mcq.getId());
                System.out.println(mcq.getQuestion());
                System.out.println(mcq.getOptions());
                System.out.println(mcq.getAnswer());
            }
            // TODO: try to print the following fields of the question
        }
    }
}
