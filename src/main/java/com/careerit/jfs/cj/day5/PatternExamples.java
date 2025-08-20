package com.careerit.jfs.cj.day5;

public class PatternExamples {
    public static void main(String[] args) {

        int n = 3;
        int m = 5;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i == j){
                    continue; // Skip the iteration if i equals j
                }
                System.out.println(i+" "+j);
            }
        }
    }
}
