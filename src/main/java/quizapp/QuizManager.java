package quizapp;

public class QuizManager {

    public static void main(String[] args) throws InterruptedException {

        QuizService quizService = new QuizService();
        quizService.startQuiz();

    }

}
