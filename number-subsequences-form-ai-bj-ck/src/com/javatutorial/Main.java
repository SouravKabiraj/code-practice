package com.javatutorial;

public class Main {

    public static void main(String[] args) {
        int count = getNumberOfSubSequence("abcabc", 0);
        System.out.println(count);
    }

    private static int getNumberOfSubSequence(String pattern, int index) {
        if (index == pattern.length()) {
            for (int i = 0; i < pattern.length() - 1; i++) {
                if ((pattern.charAt(i) + 1 == pattern.charAt(i + 1)) || (pattern.charAt(i) == pattern.charAt(i + 1))) {
                    continue;
                } else {
                    return 0;
                }
            }
            boolean b = pattern.contains("a") && pattern.contains("b") && pattern.contains("c");
            return b ? 1 : 0;
        } else {
            String front = pattern.substring(0, index);
            String tail = pattern.substring(index + 1);
            int numberOfSubSequence1 = getNumberOfSubSequence(front + tail, index);
            int numberOfSubSequence2 = getNumberOfSubSequence(pattern, index + 1);
            return numberOfSubSequence1 + numberOfSubSequence2;
        }
    }
}
