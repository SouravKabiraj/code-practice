package com.codeforce;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        
        int[] number = new int[5];
        int[] waiter = waiter(number, 2);
        System.out.println();
    }

    static int[] waiter(int[] number, int q) {
        int[] tenPrimes = getQPrimes(q);
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            primes.add(tenPrimes[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            list.add(number[i]);
        }
        ArrayList<Integer> result = worker(list, primes);
        int[] resultArr = new int[number.length];
        Iterator<Integer> iterator = result.iterator();
        for (int i = 0; i < number.length; i++) {
            resultArr[i] = iterator.next();
        }
        return resultArr;
    }

    static ArrayList<Integer> worker(ArrayList<Integer> A, ArrayList<Integer> primes) {
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            ArrayList<Integer> AK = new ArrayList<>();
            ArrayList<Integer> BK = new ArrayList<>();
            for (int j = A.size() - 1; j >= 0; j--) {
                if (A.get(j) % primes.get(i) == 0) {
                    BK.add(A.get(j));
                    A.remove(A.get(j));
                } else {
                    AK.add(A.get(j));
                }
            }
            A = AK;
            B.addAll(reverse(BK));
        }
        A = reverse(A);
        B.addAll(A);
        return B;
    }

    private static ArrayList<Integer> reverse(ArrayList<Integer> list) {
        ArrayList<Integer> rev = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            rev.add(list.get(i));
        }
        return rev;
    }

    private static int[] getQPrimes(int Q) {
        int index = 1;
        int[] primes = new int[Q];
        primes[0] = 2;
        for (int i = 3; index < Q; i++) {
            boolean isPrime = true;
            for (int k = 0; k < index; k++) {
                if (i % primes[k] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[index] = i;
                index++;
            }
        }
        return primes;
    }
}
