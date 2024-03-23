public class Palindrome {
    /*


    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

    this codes
    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
    git remote set -url origin https://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@github.com/Rajeev-Ranjanc/Leetcode
     */
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
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("End");

    }

    public int length() {
        int n = 0;
        Node node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        return n;
    }

    public boolean checkPalindrome() {
        int n = length();
        int[] nums = new int[n];
        int index = 0;
        Node node = head;
        while (node != null) {
            nums[index++] = node.data;
            node = node.next;
        }
        for (int i = 0; i < n / 2; i++) {
            if (nums[i] != nums[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }


    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();

//        palindrome.insert(5);
//        palindrome.insert(4);
//        palindrome.insert(3);
        palindrome.insert(1);
        palindrome.insert(2);
//        palindrome.insert(2);
//        palindrome.insert(1);

        palindrome.display();

        System.out.println(palindrome.checkPalindrome());

    }
}
