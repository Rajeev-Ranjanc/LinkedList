package linkedlist;

public class Main {
    public static void main(String[] args) {

        LL list = new LL();
//        list.insertFirst(17);
        list.insertFirst(8);
        list.insertFirst(2);
        list.insertFirst(3);
        list.display();

        list.insertLast(155);
//        list.display();
//
//        list.insert(1001, 2);
//        list.display();
//        System.out.println(list.deleteFirst());
//
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();
//        System.out.println(list.find(1001));
//        System.out.println(list.size);
//
        list.insertRec(88 , 2);
        list.display();
//        list.insertRec(88 , 2);

//        list.display();

        System.out.println(list.getNthFromLast(1));

    }
}
