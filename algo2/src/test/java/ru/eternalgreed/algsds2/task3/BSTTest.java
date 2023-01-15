package ru.eternalgreed.algsds2.task3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void wideAllNodes() {
    }

    @Test
    void wideAllNodes1() {
        BST<Integer> bst = new BST<>(null);
        assertTrue(bst.AddKeyValue(8, 8));
        assertTrue(bst.AddKeyValue(4, 4));
        assertTrue(bst.AddKeyValue(12, 12));
        assertTrue(bst.AddKeyValue(2, 2));
        assertTrue(bst.AddKeyValue(6, 6));
        assertTrue(bst.AddKeyValue(1, 1));
        assertTrue(bst.AddKeyValue(3, 3));
        assertTrue(bst.AddKeyValue(5, 5));
        assertTrue(bst.AddKeyValue(7, 7));
        assertTrue(bst.AddKeyValue(10, 10));
        assertTrue(bst.AddKeyValue(14, 14));
        assertTrue(bst.AddKeyValue(9, 9));
        assertTrue(bst.AddKeyValue(11, 11));
        assertTrue(bst.AddKeyValue(13, 13));
        assertTrue(bst.AddKeyValue(15, 15));

        ArrayList<BSTNode> list = bst.WideAllNodes();
        for (BSTNode i : list) {
            System.out.println(i.NodeKey);
        }
        ArrayList<BSTNode> list1 = bst.WideAllNodes1();
        for (BSTNode i : list1) {
            System.out.println(i.NodeKey);
        }
    }
}