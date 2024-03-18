//remove duplicates from sorted linked list
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicates {
    ListNode head;

    private class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //functions
    public void insertFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

    }

    public void insertLast(int val) {
        //this function insertion at last just taking O(1) time because we manage the tail pointer so insertion is taking O(1)
        if (head == null) {
            insertFirst(val);
            return;
        }
        ListNode listNode = new ListNode(val);
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = listNode;

    }

    public void display() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("End");

    }

    //function to remove duplicates elements from the linked list
//    https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/0
//    https://leetcode.com/problems/remove-duplicates-from-sorted-list/

    public void deleteDuplicates() {
        ListNode node = head;

        if (node == null) {
//            System.out.println(-1);
            return;
        }

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    //    https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
    public int getMiddle() {
        // Your code here.
        //wrong
        if(head.next == null){
            return head.val;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
            int ans = slow.val;
        return ans;
    }

    public static void main(String[] args) {
        RemoveDuplicates ll = new RemoveDuplicates();
        ll.insertFirst(1);
        ll.insertLast(1);
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(222);
        ll.insertLast(4);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(5);


//        ll.display();
//        ll.deleteDuplicates();
//        ll.display();

        System.out.println(ll.getMiddle());

    }

}
/*


public static ListNode deleteDuplicates(ListNode head) {

    if (head == null) {
       return head;
    }

    ListNode node = head;

    while (node.next != null) {
        if (node.val == node.next.val) {
            node.next = node.next.next;
        } else {
            node = node.next;
        }
    }
   return head;
}

 */

