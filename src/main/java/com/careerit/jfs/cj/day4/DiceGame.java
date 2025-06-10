package com.careerit.jfs.cj.day4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceGame {

    public static void main(String[] args) {

        int num = ThreadLocalRandom.current().nextInt(1, 7); // Generates a random number between 1 and 6
        Scanner scanner = new Scanner(System.in);

        for(int i = 1; i <= 3; i++) {
            System.out.println("Guess the number on the dice (between 1 and 6): ");
            int guess = scanner.nextInt();
            if (guess == num) {
                System.out.println("You guessed number in " + i + " attempt(s). You win!");
                break;
            }
            if(i == 3){
                System.out.println("You have exhausted all attempts. The correct number was: " + num);
            } else {
                System.out.println("Wrong guess! Try again.");
            }
        }
        scanner.close();
    }
}
