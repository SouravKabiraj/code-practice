package com.javatutorial;

public class Main {

    public static void main(String[] args) {
        System.out.println((int) getNumOfSetBitFor(18));
    }

    public static double getNumOfSetBitFor(double num) {
        if (num == 0) {
            return 0;
        }
        double sqrt = Math.sqrt(num + 1);
        int sqNumber = (int) sqrt;
        double pow = Math.pow(2, sqNumber);
        double bitCount = pow / 2 * sqNumber;
        if (pow - 1 != num) {
            double diff = num - pow + 1;
            bitCount = bitCount + diff + getNumOfSetBitFor(diff - 1);
        }
        return bitCount;
    }
}
