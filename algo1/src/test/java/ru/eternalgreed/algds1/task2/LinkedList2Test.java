package ru.eternalgreed.algds1.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedList2Test {

    LinkedList2 linkedList2 = new LinkedList2();

    @BeforeEach
    void setUp() {
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(2));
        linkedList2.addInTail(new Node(3));
        linkedList2.addInTail(new Node(4));
    }

    @Test
    void addInTail() {
    }

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void count() {
    }

    @Test
    void insertAfter() {
        Node next = linkedList2.head.next;
        Node nodeToInsert = new Node(9);
        linkedList2.insertAfter(next, nodeToInsert);
        Assertions.assertEquals(next.next, nodeToInsert);
    }
}