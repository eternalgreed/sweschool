package ru.eternalgreed.algsds2.task9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeNodeTest {

    @Test
    void evenTrees() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<>(2, tree.Root);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<>(3, tree.Root);
        SimpleTreeNode<Integer> child6 = new SimpleTreeNode<>(6, tree.Root);
        SimpleTreeNode<Integer> child5 = new SimpleTreeNode<>(5, child2);
        SimpleTreeNode<Integer> child7 = new SimpleTreeNode<>(7, child2);
        SimpleTreeNode<Integer> child4 = new SimpleTreeNode<>(4, child3);
        SimpleTreeNode<Integer> child8 = new SimpleTreeNode<>(8, child6);
        SimpleTreeNode<Integer> child9 = new SimpleTreeNode<>(9, child8);
        SimpleTreeNode<Integer> child10 = new SimpleTreeNode<>(10, child8);
        tree.AddChild(tree.Root, child2);
        tree.AddChild(tree.Root, child3);
        tree.AddChild(tree.Root, child6);
        tree.AddChild(child2, child5);
        tree.AddChild(child2, child7);
        tree.AddChild(child3, child4);
        tree.AddChild(child6, child8);
        tree.AddChild(child8, child9);
        tree.AddChild(child8, child10);

        System.out.println(tree.EvenTrees());
    }

}