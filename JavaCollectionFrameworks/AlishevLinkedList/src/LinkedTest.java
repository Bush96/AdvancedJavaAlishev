
public class LinkedTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(200);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(2));
        myLinkedList.remove(2);
        System.out.println(myLinkedList);
    }
}
