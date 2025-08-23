package quizapp;

public enum QuizTopics {
    JAVA, SQL, PYTHON;

    public String fileFileName() {
        return "quiz_topics/" + this.name().toLowerCase() + "_quiz.json";
    }
}