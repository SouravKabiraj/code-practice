package com.javatutorial;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.left.left = new Tree(3);
        tree.left.right = new Tree(3);
        tree.right = new Tree(2);
        int diff = getOddEvenDiff(tree, 0);
        System.out.println(diff);
    }

    public static int getOddEvenDiff(Tree tree, int height) {
        if (tree == null) {
            return 0;
        } else {
            int sum = getOddEvenDiff(tree.left, height + 1);
            sum = sum + getOddEvenDiff(tree.right, height + 1);
            if (height % 2 == 0) {
                sum = sum - tree.data;
            } else {
                sum = sum + tree.data;
            }
            System.out.println(tree.data + "-->" + sum);
            return sum;
        }
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
