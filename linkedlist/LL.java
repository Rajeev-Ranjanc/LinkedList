package linkedlist;


import org.w3c.dom.Node;

import java.awt.*;

/*
Singly linked list
 */
public class LL {
    //    private ListNode head;
    ListNode head;
    private ListNode tail;

    //size is to count the no of node present in the linked list
//    private int size;
    public int size;

    public LL() {
        this.size = 0;
    }


    public void insertLast(int val) {
        //this function insertion at last just taking O(1) time because we manage the tail pointer so insertion is taking O(1)
        if (tail == null) {
            insertFirst(val);
            return;
        }
        ListNode listNode = new ListNode(val);
        tail.next = listNode;
        tail = listNode;
        size++;
    }


    public void insert(int val, int index) {
        if (index > size && index < 0) {
            System.out.println("index is not present in the linked list");
            return;
        }
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        ListNode temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;

        }
        ListNode listNode = new ListNode(val, temp.next);
        temp.next = listNode;
        size++;

    }


    public void insertFirst(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head;
        head = listNode;

        if (tail == null) {//when there are only one element in the linked list
            tail = head;
        }
        size++;
    }

    //insertion of node in singly linked list using Recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
        //this index represents how many index are there
    }

    private ListNode insertRec(int val, int index, ListNode listNode) {
        if (index == 0) {
            ListNode temp = new ListNode(val, listNode);
            size++;
            return temp;
        }
        listNode.next = insertRec(val, index - 1, listNode.next);
        return listNode;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;

    }

    public int deleteLast() {

        if (size <= 1) {
            return deleteFirst();
        }
        ListNode secondlast = get(size - 2);
        int value = tail.value;
        tail = secondlast;
        tail.next = null;

        size--;
        return value;

    }

    //deletion of specific node on position
    public int delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }
        ListNode prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        size--;
        return val;
    }

    public ListNode find(int value) {
        ListNode listNode = head;
        while (listNode != null) {
            if (listNode.value == value) {
                return listNode;
            } else {
                listNode = listNode.next;
            }

        }
        return null;
    }

    public ListNode get(int index) {
        ListNode listNode = head;
        for (int i = 0; i < index; i++) {
            listNode = listNode.next;
        }
        return listNode;
    }


    public void display() {
        ListNode temp = head;
//        System.out.print("linked list elements are:");
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }


    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode() {

        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    //questions
//    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public void removeDuplicate() {
        ListNode listNode = head;
        while (listNode.next != null) {
            //node.next can be null, so we need to check
            if (listNode.value == listNode.next.value) {
                listNode.next = listNode.next.next;
                size--;

            } else {
                listNode = listNode.next;
            }
        }
        tail = listNode;
        tail.next = null;
    }

    //https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
    public int getNthFromLast(int n) {
        int ln = length();
        ListNode node = head;
        for (int i = 0; i < ln - n; i++) {
            node = node.next;

        }
        return node.value;

    }

    public int length() {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    //merge two sorted list
    public static LL merge(LL first, LL second) {
        ListNode f = first.head;
        ListNode s = second.head;

        LL ans = new LL();


        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }
        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
        /*
        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
         */


    }

    //hascycle
    //https://leetcode.com/problems/linked-list-cycle/
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;

        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    //length of the cycle
//    https://www.geeksforgeeks.org/problems/find-length-of-loop/1
    public static int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    //linked list cycle 2
//    https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //Cycle detected
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }

        }
        if (length == 0) {
            return null;
        }

        //find the start node
        ListNode first = head;
        ListNode second = head;
        while (length > 0) {
            second = second.next;
            length--;
        }

        //now keep moving both forward and they will meet at cycle point
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        //now they meet at the cycle point both are pointing same node, so we can return
        //any one first or second
        return second;
    }

    //prerequisite recursion playlist kunal
    /*merge sort is lying here /Users/rajeevranjan/Desktop/NIT/LinkedList/Merge.java
        on that question to sort that linked list we are applying bubble sort
     */
    private void bubblesort() {
        bubblesort(size - 1, 0);
    }


    //    prerequisite bubble sort in recursion
    private void bubblesort(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            ListNode first = get(col);
            ListNode second = get(col + 1);
            if (first.value > second.value) {
                //do swap
                //and for swapping we have 3 condition we are at the starting middle and at last position of the linked list
                if (first == head) {

                }
            }

        }
    }


    //    this problem is to remove the given elements from the linked list
//    https://leetcode.com/problems/remove-linked-list-elements/
    public void removeElements(int val) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current!=null){
            if(current.value == val){
                prev.next = current.next;
            }
            else {
                prev = current;
            }
            current = current.next;
        }
        return;
    }

}
