package com.careerit.jfs.cj.quiz;

public class ExamClient {
    public static void main(String[] args){
        QuestionContainer questioncontainer = new QuestionContainer();
        questioncontainer.beginTest();
        questioncontainer.showResult();
    }
}
