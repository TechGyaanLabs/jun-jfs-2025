package com.careerit.jfs.cj.day26.quizservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class QuestionManager {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = QuestionManager.class.getClassLoader()
                .getResourceAsStream("questions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questions = objectMapper.readValue(inputStream,
             new TypeReference<List<Question>>() {});
        System.out.println("Total number of questions: " + questions.size());

        for (Question question : questions) {

            if(question.getType().equals(QuestionType.MCQ.name())){
                McqQuestion mcqQuestion = (McqQuestion) question;
                System.out.println("Question Id: " + mcqQuestion.getId());
                System.out.println("Question Type: " + mcqQuestion.getType());
                System.out.println("MCQ Question: " + mcqQuestion.getQuestion());
                System.out.println("Options: " + mcqQuestion.getOptions());
                System.out.println("Answer: " + mcqQuestion.getAnswer());
            }else if(question.getType().equals(QuestionType.TOF.name())){
                TrueOrFalse trueFalseQuestion = (TrueOrFalse) question;
                System.out.println("Question Id: " + trueFalseQuestion.getId());
                System.out.println("Question Type: " + trueFalseQuestion.getType());
                System.out.println("TrueFalse Question: " + trueFalseQuestion.getQuestion());
                System.out.println("Answer: " + trueFalseQuestion.isAnswer());
            }else if(question.getType().equals(QuestionType.MTF.name())){
                MatchTheFollowingQuestion matchTheFollowing = (MatchTheFollowingQuestion) question;
                System.out.println("Question Id: " + matchTheFollowing.getId());
                System.out.println("Question Type: " + matchTheFollowing.getType());
                System.out.println("MTF Question: " + matchTheFollowing.getQuestion());
                System.out.println("Pairs: " + matchTheFollowing.getPairs());
                System.out.println("Answer: " + matchTheFollowing.getAnswer());
            }else if(question.getType().equals(QuestionType.Pairs.name())){
                PairsQuestion pairsQuestion = (PairsQuestion) question;
                System.out.println("Question Id: " + pairsQuestion.getId());
                System.out.println("Question Type: " + pairsQuestion.getType());
                System.out.println("Pairs Question: " + pairsQuestion.getQuestion());
                System.out.println("Pairs: " + pairsQuestion.getPairs());
                System.out.println("Answer: " + pairsQuestion.getAnswer());
            }

        }
    }
}
