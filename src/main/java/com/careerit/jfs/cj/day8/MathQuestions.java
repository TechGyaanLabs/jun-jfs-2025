package com.careerit.jfs.cj.day8;

import com.careerit.commons.MathUtil;

import java.util.Arrays;

public class MathQuestions {

    public static void main(String[] args) {
        int[] primes = MathUtil.getPrimesInRange(2, 100);
        System.out.println(Arrays.toString(primes));
    }
}
