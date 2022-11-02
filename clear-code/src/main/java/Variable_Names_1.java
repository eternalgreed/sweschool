import java.util.ArrayList;

/**
 * 1) ptr1 - firstListIteratingPtr - firstListMovingPtr ?
 *  // Указатель для итерации по первому связному списку
 *
 * 2) result - resultListWithSummedValues
 * // Список с просуммированными значениями
 *
 * 3) node - iteratingPtr - movingPtr ?
 *  // Указатель для итерации по списку в цикле
 *
 * 4) count - countOfListNodes
 *  // Количество нод в списке
 *
 * 5) boolean remove - isRemoved
 *  // Флаг было ли удаление узла с заданным значением
 *
 * 6) nodes - foundNodesList
 *  // Список с найденными нодами
 *
 * 7) newCapacity - shrunkCapacity
 *  // Уменьшенная вместимость/емкость
 *
 *  8) slot - slotIndex
 *   // Индекс слота после примения хэш функции
 * |+++++++++++++++++++++++++++++++++++++++++++++++++
 *   public boolean isSubset(PowerSet set2)
 *     {
 *         // возвращает true, если set2 есть
 *         // подмножество текущего множества,
 *         // иначе false
 *         if (set2.size() == 0) {
 *             return true;
 *         }
 *         if (size() >= set2.size()) {
 *             boolean result;
 *             for (String value : set2.hashtable.values()) {
 *                 result = hashtable.contains(value);
 *                 if (!result) {
 *                     return false;
 *                 }
 *             }
 *             return true;
 *         }
 *         return false;
 *     }
 * |++++++++++++++++++++++++++++++++++++++++++++++++++
 * 9) result - isSubset
 *  // Является ли множество подможеством
 *
 * 10) value - setElement
 * // Элемент множества
 *
 * 11) poppedElem - extractedElement
 *  // Извлеченный элемент из стека
 *
 *   public T removeFront() {
 *         if (this.deque.size() > 0) {
 *             T current = this.deque.get(0);
 *             this.deque.remove(0);
 *             return current;
 *         }
 *         return null;
 *     }
 *
 *  12) current - extractedElement
 *   ..Извлеченный элемент
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public static LinkedList addTwoLL(LinkedList first, LinkedList second) {
        int firstSize = first.count();
        int secondSize = second.count();
        LinkedList result = new LinkedList();
        if (firstSize != secondSize) {
            return result;
        }
        Node ptr1 = first.head;
        Node ptr2 = second.head;
        for (int i = 0; i < firstSize; i++) {
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
            if (head == null) {
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

        /*if (nodeAfter == null) {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
            if (head.getNext() == null) {
                tail = nodeToInsert;
            }
        } else if (getNodeByValue(nodeAfter.getValue()) != null) {
            nodeToInsert.setNext(nodeAfter.getNext());
            nodeAfter.setNext(nodeToInsert);
            if (nodeToInsert.getNext() == null) {
                tail = nodeToInsert;
            }
        }*/
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }


    /* void deleteAllNode(int key) {
         Node temp = head;
         while (temp != null && temp.next != null) {
             if (temp.next.value == key) {
                 temp.next = temp.next.next;
             } else {
                 temp = temp.next;
             }
         }
         if (head != null && head.value == key) {
             head = head.next;
         }
     }*/


}


class LinkedList2 {
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
        if (_nodeAfter == null)
        {
            var oldHead = head;
            head = _nodeToInsert;
            head.next = oldHead;
            head.prev = null;
            if (oldHead == null) tail = head;
            else oldHead.prev = head;
            return;
        }

        if (_nodeAfter == tail)
        {
            addInTail(_nodeToInsert);
            return;
        }
        var oldNext = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next = oldNext;
        oldNext.prev = _nodeToInsert;
        _nodeToInsert.prev = _nodeAfter;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}



public class Variable_Names_1 {

}
