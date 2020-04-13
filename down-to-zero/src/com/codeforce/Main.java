package com.codeforce;

public class Main {
    public static int[] DP;
    public static int LIMIT = 999999;

    public static void main(String[] args) {
        DP = buildSolutions();
        System.out.println();
    }

    static int[] buildSolutions() {
        int[] solutions = new int[LIMIT + 1];
        for (int i = 1; i < solutions.length; i++) {
            solutions[i] = solutions[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    solutions[i] = Math.min(solutions[i], solutions[i / j] + 1);
                }
            }
        }
        return solutions;
    }

}
