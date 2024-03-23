import linkedlist.LL;

//https://leetcode.com/problems/merge-two-sorted-lists/merge-two-sorted-lists
public class Merge {
    private ListNode head;

    public void insert(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;

    }

    public void display() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }


//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//    }

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

    public static void main(String[] args) {
        Merge merge = new Merge();
        Merge merge1 = new Merge();
        merge.insert(1);
        merge.insert(2);
        merge.insert(4);
        merge.display();

        merge1.insert(1);
        merge1.insert(3);
        merge1.insert(4);
        merge1.display();
    }


}

