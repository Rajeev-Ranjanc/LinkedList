package linkedlist;

/*
Singly circular linked list
 */
public class CircularLL {
    private Node head;
    private Node tail;
    public int size;

    CircularLL() {
        size = 0;
        head = null;
        tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
//        node.next = head;
        tail.next = node;
        node.next = head;
        tail = node;
        size++;

    }

    public void delete(int val) {
        Node node = head;
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        if (node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if (n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;

        } while (node != head);

    }

    public void display() {
        /*
        I can also print head to tail
         */
        Node node = head;
        do {
            System.out.print(node.val + " -> ");
            node = node.next;
        } while (node != head);
        System.out.println("Heads");
    }


    private class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
