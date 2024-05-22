//https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
/*
    In this question it asked me two segregate the linked list elements first even numbers then the second numbers
    to do this in that I had given O(n) extra space and said to not create a new linked list instead of this write-in
    original liked list, so I have declared two Arraylist one is for even number and other is for the odd numbers and then
    all elements of even and odd arraylist merged into  a single array. then defined a temp variable and overwrite all
    node of the linked list
 */
package linkedlist;

import java.util.ArrayList;
import java.util.List;

class Link {
    class Node {
        int data;
        Node next;

        Node(int n) {
            this.next = null;
            data = n;
        }

        Node() {
            this.next = null;
            this.data = 0;
        }
    }

    Node head = null;

    Node divide(int N, Node head) {
        // code here
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        Node temp = head;
        int first = 0;
        int second = N - 1;

        while (temp != null) {
            int t = temp.data;
            if (t % 2 == 0) {
                even.add(t);
            } else {
                odd.add(t);
            }
            temp = temp.next;
        }

        //Now Operation
        int[] arr = new int[N];
        int index = 0;
        int i = 0;
        while (true) {
            if (i < even.size()) {
                arr[index++] = even.get(i++);
            } else {
                break;
            }
        }
        i = 0;
        while (index < N) {
            arr[index++] = odd.get(i++);
        }

        System.out.println(even + " " + odd);
        //Now operation in linked list
        temp = head;
        index = 0;
        while (temp != null) {
            temp.data = arr[index++];
            temp = temp.next;
        }
        return head;

    }

    public void insertFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;


    }

    public void printLinkedList() {

        if (head == null) {
            System.out.println("Linked List is empty");
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("end");
    }


    //    https://leetcode.com/problems/odd-even-linked-list/
//      https://www.geeksforgeeks.org/problems/rearrange-a-linked-list/1
    /*
            To solve this i have defined two head nodes one is for the odd numbers and other is for the even numbers
            and declare two odd and even variables to traverse the linked list. one itt var is also declared to count
            the indexes like odd or even and if itt is even then added that node into even numbers otherwise into odd
            linked list and till we came up creating two linked list, and finally I linked even linked list with odd list,
            and we connect head with next part of even head(evenDummy)

     */
    void rearrangeEvenOdd(Node head) {
        //  The task is to complete this method
        Node oddDummy = new Node(-1);
        Node evenDummy = new Node(-1);
        Node odd = oddDummy;
        Node even = evenDummy;
        int itt = 0;
        Node temp = head;

        while (temp != null) {

            if (itt % 2 == 0) {

                even.next = temp;
                even = even.next;

            } else {

                odd.next = temp;
                odd = odd.next;

            }

            temp = temp.next;
            itt++;

        }

        //for odd numbers before
//        even.next = null;
//        odd.next = evenDummy.next;
//        head = oddDummy.next;

//        print(head);
//
        //for even numver before

        odd.next = null;
        even.next = oddDummy.next;
        head = evenDummy.next;


        print(head);


    }


    public void print(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.println("end");
    }

}


public class SegerateOddEven {

    public static void main(String[] args) {
/*
[2,1,3,5,6,4,7]
 */
        Link link = new Link();
        link.insertFirst(0);
        link.insertFirst(1);
        link.insertFirst(1);
        link.insertFirst(0);

        link.rearrangeEvenOdd(link.head);

//        link.divide()

//        link.printLinkedList();
//
//        link.divide(4, link.head);
//
//        link.printLinkedList();

    }
}
