package com.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitString = bufferReader.readLine().split(" ");
        int[] arr = new int[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            arr[i] = Integer.parseInt(splitString[i]);
        }
        System.out.println(solve(arr));
    }


    static int solve2(int[] t) {
        int[] result = new int[t.length];
        int index = 0;

        for (int i = 0; i < t.length; i++) {
            if (t[i] < t.length && i > t[i]) {
                result[i]++;
            } else if (t[i] < t.length && i < t[i]) {
                result[i]++;
            }
            if (result[i] > result[index]) {
                index = i;
            }
        }
        return index;
    }

    static int solve(int[] t) {
        int[] result = new int[t.length];
        int index = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = i; j < t.length; j++) {
                if (t[j] <= j - i) {
                    result[i]++;
                }
            }
            for (int j = 0; j < i; j++) {
                if (t[j] <= t.length - i + j) {
                    result[i]++;
                }
            }
            if (result[i] > result[index]) {
                index = i;
            }
        }
        return index + 1;
    }

    static int getMax(int[] t) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > max) {
                max = t[i];
                index = i;
            }
        }
        return index + 1;
    }
}
