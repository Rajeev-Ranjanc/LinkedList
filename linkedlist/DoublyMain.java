package linkedlist;

public class DoublyMain {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(5);
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(7);
        list.insertFirst(15);
        list.display();

//        System.out.println(list.size);
//        list.displayrev();

        list.insertLast(121);
        list.insertLast(122);
        list.insertLast(123);
        list.insertLast(124);
        list.insertLast(125);
        list.insertLast(126);

        list.insert(7 , 1111);

        list.display();

        list.displayrev();
        System.out.println(list.size);
    }
}
