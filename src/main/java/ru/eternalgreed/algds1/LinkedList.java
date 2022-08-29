package ru.eternalgreed.algds1;

import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public static LinkedList addTwoLL(LinkedList first, LinkedList second) {
        Node ptr1 = first.head;
        Node ptr2 = second.head;
        int firstSize = 0;
        int secondSize = 0;
        while (ptr1 != null) {
            firstSize++;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            secondSize++;
            ptr2 = ptr2.next;
        }
        if (firstSize != secondSize) {
            return new LinkedList();
        }
        LinkedList result = new LinkedList();
        ptr1 = first.head;
        ptr2 = second.head;
        while (ptr1 != null) {
            result.addInTail(new Node(ptr1.value + ptr2.value));
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return result;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов
        Node ptr = head;
        while (ptr != null) {
            if (ptr.value == _value) {
                nodes.add(ptr);
            }
            ptr = ptr.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        // здесь будет ваш код удаления одного узла по заданному значению
        if (head == null) {
            return false;
        }
        if (head.value == _value) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return true;
        }
        Node ptr = this.head;
        while (ptr.next != null) {
            if (ptr.next.value == _value) {
                ptr.next = ptr.next.next;
                if (ptr.next == null) {
                    tail = ptr;
                }
                return true;
            } else {
                ptr = ptr.next;
            }
        }
        return false; // если узел был удалён
    }

    public void removeAll(int _value) {
        Node temp = head;
        while (temp != null && temp.next != null) { //check for rest of the node except first
            if (temp.next.value == _value) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        if (head != null && head.value == _value) { //If first node also contain the key
            head = head.next;
            if (head ==null) {
                tail = null;
            }
        }
        // здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear() {
        while (head != null) {
            head = head.next;
        }
        tail = null;
    }

    public int count() {
        int count = 0;
        Node ptr = head;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            head = _nodeToInsert;
        }
        Node ptr = head;
        while (ptr != _nodeAfter) {
            ptr = ptr.next;
        }
        Node tmp = ptr.next;
        ptr.next = _nodeToInsert;
        _nodeToInsert.next = tmp;
        if (tmp == null) {
            tail = _nodeToInsert;
        }
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }


    /* void deleteAllNode(int key) {
         Node temp = head;
         while (temp != null && temp.next != null) { //check for rest of the node except first
             if (temp.next.value == key) {
                 temp.next = temp.next.next;
             } else {
                 temp = temp.next;
             }
         }
         if (head != null && head.value == key) { //If first node also contain the key
             head = head.next;
         }
     }*/


}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}