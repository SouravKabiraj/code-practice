package com.hackerRank;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(1);
        int node = getNode(linkedList1.start, 0);
        System.out.println(node);
    }

    static int getLength(SinglyLinkedListNode head) {
        int count = 0;
        SinglyLinkedListNode pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }
        return count;
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        int length = getLength(head);
        int position = length - positionFromTail - 1;
        SinglyLinkedListNode pointer = head;
        while (position != 0) {
            pointer = pointer.next;
            position--;
        }
        return pointer.data;
    }

    public static void levelOrder(SinglyLinkedListNode root) {

    }

    public static SinglyLinkedListNode marge(SinglyLinkedListNode s1, SinglyLinkedListNode s2) {
        LinkedList linkedList = new LinkedList();
        while (s1 != null && s2 != null) {
            if (s1.data < s2.data) {
                linkedList.add(s1.data);
                s1 = s1.next;
            } else {
                linkedList.add(s2.data);
                s2 = s2.next;
            }
        }

        while (s1 != null) {
            linkedList.add(s1.data);
            s1 = s1.next;
        }

        while (s2 != null) {
            linkedList.add(s2.data);
            s2 = s2.next;
        }

        return linkedList.start;
    }
}

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int element) {
        this.data = element;
        this.next = null;
    }
}

class LinkedList {
    public SinglyLinkedListNode start;

    public void add(int element) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(element);
        if (this.start == null) {
            this.start = node;
        } else {
            var pointer = this.start;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
        }
    }
}

