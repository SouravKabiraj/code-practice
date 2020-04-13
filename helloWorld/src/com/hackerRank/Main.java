package com.hackerRank;

public class Main {

    public static void main(String[] args) {
        Linklist linklist = new Linklist();
        linklist.add(0);
        linklist.add(1);
        linklist.add(2);
        linklist.add(3);
        linklist.add(4);
        linklist.add(5);
        linklist.add(6);
        linklist.add(7);
        linklist.addAt(-1, 4);
        linklist.removeAt(4);
        linklist.show();
    }
}

class Node {
    public int item;
    public Node next;

    Node(int item) {
        this.item = item;
        this.next = null;
    }
}

class Linklist {
    private Node start = null;

    public void add(int element) {
        Node newNode = new Node(element);
        if (this.start == null) {
            this.start = newNode;
        } else {
            Node pointer = this.start;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = newNode;
        }
    }

    public void addAt(int element, int index) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = this.start;
            this.start = newNode;
        } else {
            Node pointer = this.start;
            int count = 1;
            while (count != index) {
                pointer = pointer.next;
                count++;
            }
            newNode.next = pointer.next;
            pointer.next = newNode;
        }
    }

    public void removeAt(int index) {
        if (index == 0) {
            this.start = this.start.next;
        } else {
            Node pointer = this.start;
            int count = 1;
            while (count != index) {
                pointer = pointer.next;
                count++;
            }
            pointer.next = pointer.next.next;
        }
    }

    public void show() {
        Node pointer = this.start;
        while (pointer != null) {
            System.out.println(pointer.item);
            pointer = pointer.next;
        }
    }
}