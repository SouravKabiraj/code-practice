package com.javatutorial;

public class Main {

    public static void main(String[] args) {
        int i = countPath(0, 0, 1, 2, 2, 3);
        System.out.println(i);
    }

    public static int countPath(int fromX, int fromY, int toX, int toY, int m, int n) {
        if (fromX == toX || fromY == toY) {
            return 1;
        } else if (m == fromX || n == fromY) {
            return 0;
        } else {
            int countRightPaths = countPath(fromX + 1, fromY, toX, toY, m, n);
            int countDownPaths = countPath(fromX, fromY + 1, toX, toY, m, n);
            return countRightPaths + countDownPaths;
        }
    }
}
