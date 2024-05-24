
//https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
class NodeL {
    int data;
    NodeL next;

    NodeL(int data) {
        this.data = data;
        next = null;
    }
}

class Intersection {

    public NodeL insert(NodeL head, int data) {

        NodeL newNOde = new NodeL(data);
        if (head == null) {
            head = newNOde;
            return head;

        }

        NodeL temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNOde;
        return head;


    }


    //    https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
/*
        To solve this problem first of all I find the length of the both linked list and check whether
        it is equal or not if not then we make both equal and then start traversing using any node either
       tempA or tempB and make a check is both nodes are equal if yes then return that node otherwise keep
       traversing till the last of the linked list and finally if you don't get any equal node return the
       null

*/
    public NodeL getIntersectionNode(NodeL headA, NodeL headB) {


        NodeL tempA = headA;
        NodeL tempB = headB;

        int a = length(tempA);
        int b = length(tempB);

        System.out.println(a + " " + b);

        if (a != b) {

            if (a > b) {

                while (a != b) {
                    tempA = tempA.next;
                    a--;
                }

            } else {
                while (a != b) {
                    tempB = tempB.next;
                    b--;
                }
            }

        }

        System.out.println(a + "     " + b);

        while (tempA != null) {
            if (tempA.data == tempB.data) {
                return tempB;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;

    }

    //calculating the length of the linked list
    public int length(NodeL head) {
        NodeL temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }


    //printing the linked list
    public void printList(NodeL head) {
        NodeL A = head;

        while (A != null) {
            System.out.print(A.data + "->");
            A = A.next;
        }
        System.out.println("end");

    }


//    https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it
/*
    First of all counted occurrences of 0 1 and 2 pasted in an array and then override the linked list value by the
    array elements
 */
    NodeL segregate(NodeL head) {
        // add your code here
        int h = length(head);
        int zero = 0;
        int one = 1;
        NodeL temp = head;

        //finding no of occurrences of 0 1 2
        while (temp != null) {
            if (temp.data == 0) {
                zero++;

            } else if (temp.data == 1) {
                one++;
            }
            temp = temp.next;
        }

        int[] a = new int[h];

        for (int i = 0; i < h; i++) {
            if (i < zero) {
                a[i] = 0;
            } else if (i < zero + one - 1) {
                a[i] = 1;
            } else {
                a[i] = 2;
            }
        }
        temp = head;
        int index = 0;
        while (temp != null) {
            temp.data = a[index++];
            temp = temp.next;

        }
        return head;
    }

}

public class IntersecrtionOfLinkedList {
    public static void main(String[] args) {

        /*
         for intersection point

        Intersection in = new Intersection();
        NodeL headA = null;
        NodeL headB = null;

        headA = in.insert(headA, 4);
        headA = in.insert(headA, 1);
        headA = in.insert(headA, 8);
        headA = in.insert(headA, 4);
        headA = in.insert(headA, 5);

        headB = in.insert(headB, 5);
        headB = in.insert(headB, 6);
        headB = in.insert(headB, 1);
        headB = in.insert(headB, 8);
        headB = in.insert(headB, 4);
        headB = in.insert(headB, 5);

        in.printList(headA);
        in.printList(headB);

        NodeL temp = in.getIntersectionNode(headA, headB);

        in.printList(temp);


         */
//        for sorting 0 1 and 2
        Intersection in = new Intersection();

        NodeL head = null;

        head = in.insert(head, 1);
        head = in.insert(head, 2);
        head = in.insert(head, 2);
        head = in.insert(head, 1);
        head = in.insert(head, 2);
        head = in.insert(head, 0);
        head = in.insert(head, 2);
        head = in.insert(head, 2);

        head = in.segregate(head);
        in.printList(head);

    }
}
