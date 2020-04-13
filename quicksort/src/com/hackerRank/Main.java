package com.hackerRank;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int[] list = new int[10];
        list[0] = 9;
        list[1] = 0;
        list[2] = 8;
        list[3] = 1;
        list[4] = 10;
        list[5] = 6;
        list[6] = 7;
        list[7] = 8;
        list[8] = 11;
        list[9] = 2;
        int[] sortedList = Sort.heapSort(list, 10);
        System.out.println(sortedList);
    }
}

class Sort {
    public static int[] quickSort(int[] list, int start, int end) {
        if (start < end) {
            int pivot = getPivot(list, start, end);
            list = quickSort(list, start, pivot - 1);
            list = quickSort(list, pivot + 1, end);
            return list;
        } else {
            return list;
        }
    }

    public static int getPivot(int[] list, int start, int end) {
        int i = start - 1;
        int pivot = end;
        for (int j = start; j < end; j++) {
            if (list[j] < list[pivot]) {
                i++;
                var temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        var temp = list[i + 1];
        list[i + 1] = list[pivot];
        list[pivot] = temp;
        return i + 1;
    }

    public static int[] heapify(int[] list, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < n && list[left] > list[largest]) {
            largest = left;
        }

        if (right < n && list[right] > list[largest]) {
            largest = right;
        }

        if (largest != i) {
            var temp = list[largest];
            list[largest] = list[i];
            list[i] = temp;
            heapify(list, n, largest);
        }
        return list;
    }

    public static int[] heapSort(int[] list, int n) {
        for (var i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }
        for (var i = n - 1; i >= 0; i--) {
            var temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            heapify(list, i, 0);
        }
        return list;
    }
}
