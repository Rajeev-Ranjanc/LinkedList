package linkedlist;

import java.util.Scanner;

public class DLL {
    private Node head;
    public int size;

    DLL() {
        this.size = 0;
    }

    public void insertFirst(int value) {

        Node node = new Node(value);

        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void displayrev() {
        Node temp = head;
        Node last = null;
        while (temp != null) {

            last = temp;
            temp = temp.next;
        }
        System.out.println("Printing in reverse order of linked list:");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("Start");
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = node;
        node.prev = ptr;

        size++;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            } else {
                node = node.next;
            }

        }
        return null;
    }


    public void insert(int after, int val) {
        /*
         suppose I'm inserting 18 in between 5 & 7
         node.next = p.next;
         p.next = node;
         node.prev = p;
         (node.next.prev = node) -> node.next means previous part of 7
         */
        Node p = find(after);
        if (p == null) {
            System.out.println("does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;

        }


        size++;

    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }


        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

}
