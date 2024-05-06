import java.util.ArrayList;

public class DeleteMiddle {
    private Node head;


    public void insert(int value) {
        Node node = new Node(value);

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
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }

    public void deleteMiddle() {
        if (head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        Node temp = null;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
// At this point, slow points to the middle node to be removed, and temp points to the node before it

        if (temp != null) {
            temp.next = slow.next; // Remove the middle node from the list
        }

    }


    //    https://www.geeksforgeeks.org/problems/remove-every-kth-node/1
//    GFG : potd
    public void delete(int k) {


        if (head == null) {
            return;
        }
        if (k == 1) {
            //in this case I need to remove entire linked list
//            freeList();
            head = null;
        }

        int count = 1;
        Node temp = head;
        Node prev = null;
        while (temp.next != null) {

            prev = temp;
            temp = temp.next;
            count++;
            if (count == k) {
                prev.next = temp.next;
                count = 0;
            }

        }


    }

    //    https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
    /*
    Gfg Potd -> 30 april
     */
    Node addTwoLists(Node num1, Node num2) {
/*

FlipKart -> Morgan Stanley -> Amazon -> Microsoft ->

https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/0
        First we  reverse the both linked list and perform addition operation and again
        reverse then we return the reversed linked list
 */
        return num1;
    }


    public void reverse() {

    }


    public void InsertFirst() {

        Node newNode = new Node(0);
        newNode.next = null;
        if (head == null) {

            head = newNode;
        }
        newNode.next = head;
        head = newNode;

    }

    public int length() {
        Node temp = head;
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    //    https://www.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1
    public void arrangeCV() {
        //write code here and return the head of changed linked list
        Node temp = head;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        while (temp != null) {
            if (temp.value % 2 != 0) {
                odd.add(temp.value);
            } else {
                even.add(temp.value);
            }
            temp = temp.next;
        }

        Node newnode = new Node(0);
        head = newnode;
//        temp = head; // Reset temp to head

        for (Integer integer : even) {
            newnode.next = new Node(integer);
            newnode = newnode.next;
        }

        for (Integer integer : odd) {
            newnode.next = new Node(integer);
            newnode = newnode.next;
        }

        head = head.next; // Skip the dummy node at the beginning
    }


    private class Node {
        /*
        private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
         */

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;

        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        DeleteMiddle deleteiddle = new DeleteMiddle();
        deleteiddle.insert(1);
        deleteiddle.insert(2);
        deleteiddle.insert(3);
        deleteiddle.insert(4);
        deleteiddle.insert(5);
        deleteiddle.arrangeCV();


//        deleteiddle.display();

//        deleteiddle.deleteMiddle();
//        deleteiddle.delete(3);
        deleteiddle.display();
//        System.out.println(deleteiddle.length());

    }

}
