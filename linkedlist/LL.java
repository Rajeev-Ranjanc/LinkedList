
package linkedlist;


/*
Singly linked list
 */
public class LL {
    private ListNode head;
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
            System.out.print(temp.value + " ->");
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

}
