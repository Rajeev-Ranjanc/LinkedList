public class RemoveGivenNode {
    private Node head;

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


    //     https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public void deleteNode(int x) {

        /*
        Done on leetcode
        this question is done using a lot of brainstorming(mathapachhi) but finally able to solve
        first we find the length of the linked list and later we calculate the node which one is to
        be removed from end of the linked list by let's say y =  length - x(which node to be removed from
        the end) of the
        linked list and we runs a while loop until Y does not become zero till we traverse using two               pointer one is current and another one is prev once we came out of that loop we simply assign
        prev.next = node.next and if the linked list contains only one node then simply head = head.next
        and return head at that very next line

    */
        //this function deletes the nth nde from the end

        int ln = length();
        int nth = ln - x;
//        System.out.println(ln);
//        System.out.println(nth);

        if (nth == 0) {
            head = head.next;
            return;
        }
        Node node = head;
        Node prev = null;
        while (nth-- > 0) {
            prev = node;
            node = node.next;
        }

        prev.next = node.next;

    }

    //    gfg saying I have to remove xth node from the linked list
//    https://www.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
//    https://www.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
    //done on gfg
    public void deleteNodeGfg(int x) {
        if (x == 1) {
            head = head.next;
            return;
        }
        int l = x - 1;
        Node prev = null;
        Node current = head;
        while (l-- > 0) {
            prev = current;
            current = current.next;
        }
        assert prev != null;
        prev.next = current.next;
    }


    //https://leetcode.com/problems/remove-linked-list-elements/
//    https://leetcode.com/problems/remove-linked-list-elements/submissions/
    /*
    Occurring error in 77777 and val is also 7
     */
    public void removeElements(int val) {

        Node current = head;
        while (current.next != null) {
            if (current.next.data == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }


    }

    // finding the length of the linked list
    public int length() {
        int length = 0;
        Node node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }


    //class of node or node creation class
    private class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    public static void main(String[] args) {
        RemoveGivenNode rm = new RemoveGivenNode();
        rm.insert(1);
        rm.insert(2);
        rm.insert(6);
        rm.insert(3);
        rm.insert(4);
        rm.insert(5);
        rm.insert(6);
//        rm.insert(3);
//        rm.insert(3);
//        rm.insert(4);
//        rm.insert(5);
//        rm.insert(6);

        rm.display();
//        rm.deleteNode(3);
////        rm.removeElements(6);
//        rm.display();
//        rm.deleteNodeGfg(1);
        rm.removeElements(6);
        rm.display();

    }

}
