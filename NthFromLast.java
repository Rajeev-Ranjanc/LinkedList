//https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
/*
done on gfg see the question on gfg
 */

public class NthFromLast {
    private class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    int getNthFromLast(Node head, int n) {


        // Your code here


        int ln = length(head);

        if (head == null || ln < n) {

            return -1;

        }


        Node temp = head;

        for (int i = 0; i < ln - n; i++) {

            temp = temp.next;

        }
        return temp.data;


    }

    int length(Node head) {

        int count = 0;

        Node temp = head;

        while (temp != null) {

            count++;

            temp = temp.next;
        }

        return count;

    }

    public static void main(String[] args) {

        NthFromLast nth = new NthFromLast();

    }
}
