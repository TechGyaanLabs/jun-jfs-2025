package quizapp;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizQuestion {
    private int id;
    private String question;
    private String type;
    private List<String> options;
    private String answer;
}
