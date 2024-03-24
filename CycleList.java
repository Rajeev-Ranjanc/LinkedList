import linkedlist.LL;

//https://leetcode.com/problems/linked-list-cycle/
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class CycleList {
    public static void main(String[] args) {

    }

    //optimal way to using slow and fast pointer
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


//    https://www.geeksforgeeks.org/problems/find-length-of-loop/1
    public static int lengthCycle(ListNode head) {
        int length = 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                ListNode temp = slow;

                while (temp.next != fast) {

                    length++;
                    temp = temp.next;
                }

                return length+1;
            }
        }
        return length;
    }

}
