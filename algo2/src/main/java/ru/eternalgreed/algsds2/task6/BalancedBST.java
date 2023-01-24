package ru.eternalgreed.algsds2.task6;

import java.util.*;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSTNode Root; // корень дерева

    public BalancedBST()
    {
        Root = null;
    }

    public void GenerateTree(int[] a)
    {
        // создаём дерево с нуля из неотсортированного массива a
        // ...
        Arrays.sort(a);
        generateBBST(Root, a, 0, a.length - 1);
    }

    private BSTNode generateBBST(BSTNode parent, int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int middleIndex = (startIndex + endIndex + 1) / 2;
        BSTNode node = new BSTNode(array[middleIndex], parent);
        if (Root == null) {
            Root = node;
            node.Level = 0;
        } else {
            node.Level = parent.Level + 1;
        }
        node.LeftChild = generateBBST(node, array, startIndex, middleIndex - 1);
        node.RightChild = generateBBST(node, array, middleIndex + 1, endIndex);

        return node;
    }

    public boolean IsBalanced(BSTNode root_node)
    {
        // сбалансировано ли дерево с корнем root_node
        if (root_node == null) {
            return false;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if (root_node.RightChild != null) {
            rightDepth = getTreeHeight(root_node.RightChild);
        }
        if (root_node.LeftChild != null) {
            leftDepth = getTreeHeight(root_node.LeftChild);
        }
        return Math.abs(leftDepth - rightDepth) <=1;
    }

    private int getTreeHeight(BSTNode node) {
        if (node.LeftChild == null && node.RightChild == null) {
            return node.Level;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if (node.LeftChild != null) {
            leftDepth = getTreeHeight(node.LeftChild);
        }
        if (node.RightChild != null) {
            rightDepth = getTreeHeight(node.RightChild);
        }
        return Math.max(leftDepth, rightDepth);
    }
}