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

        System.out.println(even+" "+odd);
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

        newNode.next = head;
        head = newNode;


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

}


//https://leetcode.com/problems/odd-even-linked-list/

public class SegerateOddEven {

    public static void main(String[] args) {

        Link link = new Link();
        link.insertFirst(7);
        link.insertFirst(5);
        link.insertFirst(3);
        link.insertFirst(1);

//        link.divide()

        link.printLinkedList();
        link.divide(4, link.head);
        link.printLinkedList();
    }
}
