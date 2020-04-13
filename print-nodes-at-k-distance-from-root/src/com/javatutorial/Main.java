package com.javatutorial;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.right = new Node(2);
        tree.left = new Node(3);
        tree.left.left = new Node(10);
        tree.left.right = new Node(11);
        tree.right.left = new Node(4);
        tree.right.left.left = new Node(5);
        tree.right.left.right = new Node(6);
        tree.right.right = new Node(7);
        ArrayList<Integer> kthLevelNodes = getKthLevelNodes(tree, 2);
        System.out.println(kthLevelNodes);
    }

    public static ArrayList<Integer> getKthLevelNodes(Node tree, Integer level) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (tree == null) {
            return integers;
        }
        if (level == 0) {
            integers.add(tree.data);
        } else {
            ArrayList<Integer> leftNodes = getKthLevelNodes(tree.left, level - 1);
            ArrayList<Integer> rightNodes = getKthLevelNodes(tree.right, level - 1);
            leftNodes.forEach(data -> {
                integers.add(data);
            });
            rightNodes.forEach(data -> {
                integers.add(data);
            });
        }
        return integers;
    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }
}