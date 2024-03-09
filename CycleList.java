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

}
