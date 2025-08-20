package quizapp;

import com.careerit.jfs.cj.day26.quizservice.QuestionManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class QuizService {


    private List<QuizQuestion> loadQuestions() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = QuestionManager.class.getClassLoader()
                    .getResourceAsStream("quiz_topics/java_quiz.json");
            return mapper.readValue(inputStream, new TypeReference<List<QuizQuestion>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void evaluateAndShowResult(List<QuizQuestion> question, List<QuizUserResponse> userResponseList) throws InterruptedException {
        System.out.println("Please wait while we evaluate your response");
        TimeUnit.SECONDS.sleep(5);
        int score = 0;
        for (int i = 0; i < question.size(); i++) {
            QuizQuestion quizQuestion = question.get(i);
            displayQuestion(quizQuestion);
            System.out.println("Correct Answer: " + quizQuestion.getAnswer());
            System.out.println("Your Answer: " + userResponseList.get(i).getAnswer());
            if (quizQuestion.getAnswer().equals(userResponseList.get(i).getAnswer())) {
                score++;
                System.out.println("Correct Answer");
            } else {
                System.out.println("Wrong Answer");
            }
            System.out.println("\n");
        }
        System.out.println("Total questions: " + question.size());
        System.out.println("Total correct answers: " + score);
        System.out.println("Total wrong answers: " + (question.size() - score));
        System.out.println("Your score is: " + (score * 100) / question.size() + "%");
    }

    public void startQuiz() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hi " + name + ", thank for showing interest in taking java quiz");
        System.out.println("Your quiz is going start in few seconds");
        TimeUnit.SECONDS.sleep(5);
        List<QuizQuestion> question = loadQuestions();
        List<QuizUserResponse> userResponseList = new ArrayList<>();
        for (QuizQuestion quizQuestion : question) {
            displayQuestion(quizQuestion);
            System.out.println("Enter your answer: ");
            String answer = new Scanner(System.in).nextLine();
            userResponseList.add(new QuizUserResponse(quizQuestion.getId(), answer));
            System.out.println("\n");
        }
        evaluateAndShowResult(question, userResponseList);
        System.out.println("\nThanks for taking the quiz\n");
    }

    private void displayQuestion(QuizQuestion quizQuestion) {
        System.out.println("\n");
        System.out.println("Question " + quizQuestion.getId() + ": " + quizQuestion.getQuestion());
        System.out.println("Options: ");
        for (int j = 0; j < quizQuestion.getOptions().size(); j++) {
            String[] arr = quizQuestion.getOptions().get(j).split(":");
            System.out.println(arr[0] + ") " + arr[1].trim());
        }
    }
}
