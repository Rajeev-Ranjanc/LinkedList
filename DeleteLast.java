public class DeleteLast {
    Node head;

    public void insert(int val) {
        Node node = new Node(val);
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
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }

    public void deleteLast() {
        Node node = head;
        Node temp = head;

        while (node.next != null) {
            temp = node;
            node = node.next;
        }
        temp.next = null;

    }


    //https://www.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
    public void deleteXthNode(int x) {
        if(head.next == null){
            return;
        }

        Node temp = head;
        for (int i = 0; i < x-2; i++) {
            temp=temp.next;
        }
        temp.next = temp.next.next;
//        System.out.println(temp.data);

    }

    public static void main(String[] args) {
        DeleteLast deleteLast = new DeleteLast();
        deleteLast.insert(4);
        deleteLast.insert(2);
        deleteLast.insert(5);
        deleteLast.insert(1);

        deleteLast.display();

        deleteLast.deleteLast();
        deleteLast.display();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {
        DeleteLast dl = new DeleteLast();
//        dl.insert(1);
//        dl.insert(5);
//        dl.insert(2);
        dl.insert(7);
        dl.insert(9);
//        dl.deleteLast();
        dl.display();

        dl.deleteXthNode(1);
        dl.display();
    }
}
