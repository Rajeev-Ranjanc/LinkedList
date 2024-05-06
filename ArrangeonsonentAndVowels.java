import java.util.*;
//https://www.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class ArrangeonsonentAndVowels {
    Node head = null;

    private class Node {
        private char value;
        private Node next;

        public Node(char value) {
            this.value = value;

        }

        public Node(char value, Node next) {
            this.value = value;
            this.next = next;

        }
    }

    public void insert(char value) {
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

        if (head == null) {
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("end");
    }


//   https://www.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1
    public void arrangeCV() {
        //write code here and return the head of changed linked list
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        ArrayList<Character> vowel = new ArrayList<>();
        ArrayList<Character> cons = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            char ch = temp.value;
            if (vowels.contains(ch)) {
                vowel.add(ch);
            } else {
                cons.add(ch);
            }
            temp = temp.next;
        }

        Node res = new Node('\0');
        Node newNode = res;
        for (Character character : vowel) {
            newNode.next = new Node(character);
            newNode = newNode.next;
        }
        for (Character con : cons) {
            newNode.next = new Node(con);
            newNode = newNode.next;
        }

//        return res.next;
        displayPersonal(res.next);
    }

    private void displayPersonal(Node node) {
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("end");

    }

    public static void main(String[] args) {


        ArrangeonsonentAndVowels ar = new ArrangeonsonentAndVowels();
        ar.insert('a');
        ar.insert('b');
        ar.insert('c');
        ar.insert('d');
        ar.insert('e');
        ar.insert('f');
        ar.insert('g');
        ar.insert('h');
        ar.insert('i');
        ar.arrangeCV();

        ar.display();

    }
}
