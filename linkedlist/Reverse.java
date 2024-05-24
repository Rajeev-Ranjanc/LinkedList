package linkedlist;

public class Reverse {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){

            return head;
        }

        ListNode prevnode = null;
        ListNode currnode = head;
        ListNode nextnode = head;

        while(nextnode != null){

            nextnode = nextnode.next;

            currnode.next = prevnode;

            prevnode = currnode;

            currnode = nextnode;

        }

        head = prevnode;
        return head;


    }
}
