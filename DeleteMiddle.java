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
        if(head.next == null){
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

    public void reverse(){

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
//        deleteiddle.insert(3);
//        deleteiddle.insert(4);
//        deleteiddle.insert(7);
//        deleteiddle.insert(1);
//        deleteiddle.insert(2);
//        deleteiddle.insert(6);
//        deleteiddle.insert(71);
//        deleteiddle.insert(3);
//        deleteiddle.insert(4);
//        deleteiddle.insert(5);
//        deleteiddle.insert(6);

        deleteiddle.display();

        deleteiddle.deleteMiddle();
        deleteiddle.display();

    }

}
