package linkedlist;

public class Cir_Main {
    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.insert(1);
        list.insert(19);
        list.insert(47);
        list.insert(44);
        list.insert(84);
        list.display();

        list.delete(19);
        list.display();
    }
}
