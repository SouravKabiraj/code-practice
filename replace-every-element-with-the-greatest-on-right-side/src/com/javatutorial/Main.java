package com.javatutorial;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(9);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(1);
        arrayList.add(2);
        ArrayList<Integer> greatestRightArray = getGreatestRightArray(arrayList);
        for (int i = 0; i < greatestRightArray.size() / 2; i++) {
            greatestRightArray.set(i, greatestRightArray.get(i) + greatestRightArray.get(greatestRightArray.size() - i - 1));
            greatestRightArray.set(greatestRightArray.size() - i - 1, greatestRightArray.get(i) + greatestRightArray.get(greatestRightArray.size() - i - 1));
            greatestRightArray.set(i, greatestRightArray.get(greatestRightArray.size() - i - 1) - greatestRightArray.get(i));
            greatestRightArray.set(greatestRightArray.size() - i - 1, greatestRightArray.get(greatestRightArray.size() - i - 1) - 2 * greatestRightArray.get(i));
        }
        System.out.println(greatestRightArray);
    }

    public static ArrayList<Integer> getGreatestRightArray(ArrayList<Integer> list) {
        Integer max = -1;
        ArrayList<Integer> returnArr = new ArrayList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            returnArr.add(max);
            max = max < list.get(i) ? list.get(i) : max;
        }
        return returnArr;
    }
}
