package com.javatutorial;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> mat = new ArrayList<>();
        mat.add(10);
        mat.add(30);
        mat.add(5);
        mat.add(60);
        int numberOfCalculation = getNumberOfCalculation(mat);
        System.out.println(numberOfCalculation);
    }

    public static int getNumberOfCalculation(List<Integer> mat) {
        if (mat.size() > 3) {
            int min = 999999;
            for (int i = 1; i < mat.size() - 1; i++) {
                int leftCount = getNumberOfCalculation(mat.subList(0, i + 1));
                int rightCount = getNumberOfCalculation(mat.subList(i, mat.size()));
                int totalCount = mat.get(0) * mat.get(i) * mat.get(mat.size() - 1) + leftCount + rightCount;
                if (min > totalCount) {
                    min = totalCount;
                }
            }
            return min;
        } else if (mat.size() == 3) {
            return mat.get(0) * mat.get(1) * mat.get(2);
        } else {
            return 0;
        }
    }
}
