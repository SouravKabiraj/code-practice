package com.codeforce;

public class Main {

    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 1;
        A[1] = 1;
        A[2] = 1;
        A[3] = 1;
        A[4] = 1;
        A[5] = 1;
        A[6] = 0;

        log(getSize(A));
    }

    private static void log(int size) {
        System.out.println(size);
    }

    private static int getSize(int[] A) {
        return getSizeFor(A, 0, 0, 0) * 2;
    }

    private static int getSizeFor(int[] A, int zeros, int ones, int index) {
        if (index == A.length) {
            if (zeros == ones) {
                return zeros;
            } else {
                return 0;
            }
        } else if (A[index] == 1) {
            int way1 = getSizeFor(A, zeros, ones + 1, index + 1);
            int way2 = getSizeFor(A, 0, 0, index + 1);
            int i = zeros == ones ? zeros : 0;
            return Math.max(Math.max(way1, way2), i);
        } else {
            int way1 = getSizeFor(A, zeros + 1, ones, index + 1);
            int way2 = getSizeFor(A, 0, 0, index + 1);
            int i = zeros == ones ? zeros : 0;
            return Math.max(Math.max(way1, way2), i);
        }
    }
}
