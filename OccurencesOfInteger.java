//https://www.geeksforgeeks.org/problems/occurence-of-an-integer-in-a-linked-list/1
public class OccurencesOfInteger {
    private Node head;

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("End");

    }

    public int count(int val) {
        int length = 0;
        Node node = head;
        while (node != null) {
            if (node.data == val) {
                length++;
            }
            node = node.next;

        }

        return length;
    }


    private class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }

        //command + N
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        OccurencesOfInteger oc = new OccurencesOfInteger();
        oc.insert(1);
        oc.insert(2);
        oc.insert(1);
        oc.insert(2);
        oc.insert(1);
        oc.insert(3);
        oc.insert(1);

        oc.display();

        System.out.println(oc.count(1));;

    }
}
