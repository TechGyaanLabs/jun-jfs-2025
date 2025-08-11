package com.careerit.jfs.cj.quiz;

import java.util.*;
import java.util.Scanner;

public class QuestionContainer {
    List<Question> list;
    int ccount; // correct count
    int wcount; // wrong count

    public QuestionContainer() {
        list = new ArrayList<>();
        // Adding 5 questions
        list.add(new Question(
                "Java is programming or platform?",
                "A. Programming",
                "B. Platform",
                "C. Both",
                "D. None of the above",
                "C"
        ));
        list.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                "A. super",
                "B. extends",
                "C. implements",
                "D. this",
                "B"
        ));
        list.add(new Question(
                "Which company developed Java?",
                "A. Sun Microsystems",
                "B. Microsoft",
                "C. Oracle",
                "D. IBM",
                "A"
        ));
        list.add(new Question(
                "Which of the following is not a Java feature?",
                "A. Object-oriented",
                "B. Use of pointers",
                "C. Platform independent",
                "D. Portable",
                "B"
        ));
        list.add(new Question(
                "Which method is the entry point of a Java program?",
                "A. start()",
                "B. run()",
                "C. main()",
                "D. execute()",
                "C"
        ));
    }

    public void beginTest() {
        Scanner scanner = new Scanner(System.in);

        for (Question q : list) {
            System.out.println("\n" + q.question);
            System.out.println(q.option1);
            System.out.println(q.option2);
            System.out.println(q.option3);
            System.out.println(q.option4);

            String userAnswer;
            while (true) {
                System.out.print("Enter your answer (A/B/C/D): ");
                userAnswer = scanner.nextLine().trim().toUpperCase();
                if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
                    break; // valid input
                }
                System.out.println("Invalid input! Please enter A, B, C, or D only.");
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
        System.out.println("\n===== Test Result =====");
        System.out.println("Total questions : " + total);
        System.out.println("Correct         : " + ccount);
        System.out.println("Wrong           : " + wcount);

        double percentage = (ccount * 100.0) / total;
        System.out.println("Result          : " + (percentage > 40 ? "Pass" : "Fail"));
    }

}
