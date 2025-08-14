package HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String question, option1, option2, option3, option4, answer;

    public Question(String question, String option1, String option2,
                    String option3, String option4, String answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer.toUpperCase();
    }
}

class QuestionContainer {
    List<Question> list;
    int ccount, wcount;

    public QuestionContainer() {
        list = new ArrayList<>();

        // Adding 5 sample questions
        list.add(new Question(
                "1.Java is programming or platform?",
                "A. Programming", "B. Platform", "C. Both", "D. None of the above", "C"
        ));
        list.add(new Question(
                "2.Which data type is used to create a variable that should store text?",
                "A. String", "B. Txt", "C. MyString", "D. string", "A"
        ));
        list.add(new Question(
                "3.Which method can be used to find the length of a string in Java?",
                "A. getSize()", "B. length()", "C. len()", "D. getLength()", "B"
        ));
        list.add(new Question(
                "4.Which keyword is used to create a class in Java?",
                "A. class", "B. Class", "C. MyClass", "D. def", "A"
        ));
        list.add(new Question(
                "5.How do you start the execution of a Java program?",
                "A. main()", "B. start()", "C. run()", "D. execute()", "A"
        ));
    }

    public void beginTest() {
        Scanner sc = new Scanner(System.in);

        for (Question q : list) {
            System.out.println("\n" + q.question);
            System.out.println(q.option1);
            System.out.println(q.option2);
            System.out.println(q.option3);
            System.out.println(q.option4);

            String userAnswer;
            while (true) {
                System.out.print("Enter your answer (A/B/C/D): ");
                userAnswer = sc.nextLine().trim().toUpperCase();
                if (userAnswer.matches("[ABCD]")) {
                    break; // valid input
                } else {
                    System.out.println("Invalid input! Please enter only A, B, C, or D.");
                }
            }

            if (userAnswer.equals(q.answer)) {
                ccount++;
            } else {
                wcount++;
            }
        }
    }

    public void showResult() {
        int total = list.size();
        System.out.println("\n=== Exam Result ===");
        System.out.println("Total questions: " + total);
        System.out.println("Correct: " + ccount);
        System.out.println("Wrong: " + wcount);

        double percentage = (ccount * 100.0) / total;
        System.out.println("Result: " + (percentage >= 40 ? "Pass" : "Fail"));
    }

}

