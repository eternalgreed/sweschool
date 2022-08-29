import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
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
        return false;
    }

    public void removeAll(int _value) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.value == _value) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        if (head != null && head.value == _value) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
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
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = head;
            head = _nodeToInsert;
            if (head.next == null) {
                tail = _nodeToInsert;
            }
            return;
        }
        Node ptr = head;
        while (ptr != null && ptr != _nodeAfter) {
            ptr = ptr.next;
        }
        if (ptr == null) return;
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        if (_nodeToInsert.next == null) {
            tail = _nodeToInsert;
        }
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}