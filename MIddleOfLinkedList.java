//https://leetcode.com/problems/middle-of-the-linked-list/submissions/1196621833/?envType=daily-question&envId=2024-03-07
public class MIddleOfLinkedList {
    public class ListNode {
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

    public static void main(String[] args) {

    }


    public static ListNode middleNode(ListNode head) {
        //optimal way to do it
        //using slow and fast pointer
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

        //using array
    }
    public static ListNode middleNodeUsingArray(ListNode head) {
        return head;
    }
}
