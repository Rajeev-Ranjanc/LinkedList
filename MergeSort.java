/*
To solve the sort liat problem of linked list I need to compl
 */
public class MergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);

    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyhead = new ListNode();
        ListNode tail = dummyhead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyhead.next;

    }

    public ListNode getMid(ListNode head) {
        ListNode midprev = null;
        while (head != null && head.next != null) {
            midprev = (midprev == null) ? head : midprev.next;
            head = head.next.next;
        }

        ListNode mid = midprev.next;
        midprev.next = null;
        return mid;
    }

    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
