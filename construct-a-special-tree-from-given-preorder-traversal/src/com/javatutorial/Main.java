package com.javatutorial;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Tree> trees = new ArrayList<>();
        arr.add(10);
        arr.add(30);
        arr.add(20);
        arr.add(5);
        arr.add(15);
        chars.add('N');
        chars.add('N');
        chars.add('L');
        chars.add('L');
        chars.add('L');
        arr.forEach(ele -> {
            trees.add(new Tree(ele));
        });
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (chars.get(i) == 'N') {
                Tree tree = trees.get(i);
                tree.left = trees.get(i + 1);
                tree.right = trees.get(i + 2);
                trees.remove(i + 1);
                trees.remove(i + 1);
                chars.set(i, 'L');
            }
        }
        Tree x = trees.get(0);
        System.out.println(x);
    }
}

class Tree {
    public int data;
    public Tree left;
    public Tree right;

    public Tree(int data) {
        this.data = data;
    }
}
