package com.javatutorial;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int o = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1000900000);
        arr.add(80);
        arr.add(99);
        arr.add(430);
        arr.add(433);
        arr.add(1);
        arr.add(10);
        arr.add(100);
        System.out.println(radixSort(arr));
    }

    public static ArrayList<Integer> radixSort(ArrayList<Integer> arr) {
        for (int i = 1; i < 1000; i = i * 10) {
            arr = arrange(arr, i);
        }
        return arr;
    }

    public static ArrayList<Integer> arrange(ArrayList<Integer> arr, int digit) {
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bucket.add(new ArrayList<>());
        arr.forEach(element -> {
            int i = (element % (digit * 10)) / digit;
            ArrayList<Integer> oldBucket = bucket.get(i);
            oldBucket.add(element);
            bucket.set(i, oldBucket);
        });
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> integers = bucket.get(i);
            result.addAll(integers);
        }
        return result;
    }
}
