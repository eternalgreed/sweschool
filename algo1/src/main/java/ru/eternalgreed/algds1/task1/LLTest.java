package ru.eternalgreed.algds1.task1;



import java.util.List;

public class LLTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
       /* list.addInTail(new Node(1));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));*/
         Node item = new  Node(5);
       /* list.addInTail(item);
        list.addInTail(new Node(6));
        list.addInTail(new Node(7));
        list.addInTail(new Node(3));*/
        printList(list);
        boolean remove = list.remove(1);
        List< Node> all = list.findAll(3);
        System.out.println(all);
        list.removeAll(3);
        printList(list);
        int count = list.count();
        list.insertAfter(item, new  Node(10));
        //list.clear();
        LinkedList list2 = new LinkedList();
        list2.addInTail(new  Node(1));
        list2.addInTail(new  Node(1));
        list2.addInTail(new  Node(1));
        list2.addInTail(new  Node(1));
        list2.addInTail(new  Node(1));
        list2.addInTail(new  Node(1));
        LinkedList addTwoLL = LinkedList.addTwoLL(list, list2);
        printList(list);
        printList(list2);
        printList(addTwoLL);

    }

    private static void printList(LinkedList list) {
        Node ptr = list.head;
        while (ptr != null){
            System.out.print(ptr.value + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }




}
