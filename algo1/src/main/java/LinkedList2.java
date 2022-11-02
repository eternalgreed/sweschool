import java.util.ArrayList;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        // здесь будет ваш код поиска
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        // здесь будет ваш код удаления одного узла по заданному значению
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                deleteNode(node);
                return true;
            }
            node = node.next;
        }
        return false; // если узел был удалён
    }

    private void deleteNode(Node node) {
        boolean isHeadToDelete = node.prev == null;
        boolean isTailToDelete = node.next == null;
        if (isHeadToDelete) {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            return;
        }
        if (isTailToDelete) {
            tail = tail.prev;
            tail.next = null;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void removeAll(int _value) {
        boolean remove = remove(_value);
        while (remove) {
            remove = remove(_value);
        }
        /*Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                deleteNode(node);
            }
            node = node.next;
        }*/
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int count() {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
        if (_nodeAfter == null) {
            Node oldHead = head;
            head = _nodeToInsert;
            head.next = oldHead;
            head.prev = null;
            if (oldHead == null) tail = head;
            else oldHead.prev = head;
            return;
        }

        if (_nodeAfter == tail) {
            addInTail(_nodeToInsert);
            return;
        }
        Node oldNext = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next = oldNext;
        oldNext.prev = _nodeToInsert;
        _nodeToInsert.prev = _nodeAfter;
    }
}

/*
class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}*/
