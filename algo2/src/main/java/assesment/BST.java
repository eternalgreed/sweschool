

import java.io.*;
import java.util.*;


class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node)
    {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key)
    {
        // ищем в дереве узел и сопутствующую информацию по ключу
        if (Root == null){
            return new BSTFind<>();
        }
        return findNode(Root, key);
    }

    private BSTFind<T> findNode(BSTNode<T> node, int key){
        if (key == node.NodeKey) {
            BSTFind<T> foundNode = new BSTFind<>();
            foundNode.Node = node;
            foundNode.NodeHasKey = true;
            return foundNode;
        }
        if (key < node.NodeKey && node.LeftChild == null) {
            BSTFind<T> foundNode = new BSTFind<>();
            foundNode.Node = node;
            foundNode.NodeHasKey = false;
            foundNode.ToLeft = true;
            return foundNode;
        }
        if (key > node.NodeKey && node.RightChild == null) {
            BSTFind<T> foundNode = new BSTFind<>();
            foundNode.Node = node;
            foundNode.NodeHasKey = false;
            foundNode.ToLeft = false;
            return foundNode;
        }
        if (key < node.NodeKey) {
            return findNode(node.LeftChild, key);
        }
        return findNode(node.RightChild, key);
    }

    public boolean AddKeyValue(int key, T val)
    {
        // добавляем ключ-значение в дерево
        BSTFind<T> findNodeByKey = FindNodeByKey(key);
        if (findNodeByKey.NodeHasKey) {
            return false; // если ключ уже есть
        }
        if (findNodeByKey.Node == null) {
            Root = new BSTNode<>(key, val, null);
            return true;
        }
        if (findNodeByKey.ToLeft) {
            findNodeByKey.Node.LeftChild = new BSTNode<>(key, val, findNodeByKey.Node);
        } else {
            findNodeByKey.Node.RightChild = new BSTNode<>(key, val, findNodeByKey.Node);
        }
        return true;

    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        // ищем максимальный/минимальный ключ в поддереве
        BSTNode<T> tmpNode = FromNode;
        if (FindMax) {
            while (tmpNode.RightChild != null) {
                tmpNode = tmpNode.RightChild;
            }
        } else {
            while (tmpNode.LeftChild != null) {
                tmpNode = tmpNode.LeftChild;
            }
        }
        return tmpNode;
    }


    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> checkNode = FindNodeByKey(key);
        if (!checkNode.NodeHasKey) {
            return false;
        }

        BSTNode<T> curNode = checkNode.Node;

        if (curNode.LeftChild == null) {
            Transplant(curNode, curNode.RightChild);
        } else if (curNode.RightChild == null) {
            Transplant(curNode, curNode.LeftChild);
        } else {
            BSTNode<T> nextMinNode = FinMinMax(curNode.RightChild, false);

            if (nextMinNode.Parent != curNode) {
                Transplant(nextMinNode, nextMinNode.RightChild);
                nextMinNode.RightChild = curNode.RightChild;
                nextMinNode.RightChild.Parent = nextMinNode;
            }
            Transplant(curNode, nextMinNode);
            nextMinNode.LeftChild = curNode.LeftChild;
            nextMinNode.LeftChild.Parent = nextMinNode;
        }

        return true;
    }

    public void Transplant(BSTNode<T> firstNode, BSTNode<T> secondNode) {
        if (firstNode.Parent == null) {
            Root = secondNode;
        } else if (firstNode == firstNode.Parent.LeftChild) {
            firstNode.Parent.LeftChild = secondNode;
        } else {
            firstNode.Parent.RightChild = secondNode;
        }

        if (secondNode != null) {
            secondNode.Parent = firstNode.Parent;
        }
    }



    public int Count()
    {
        return getCount(Root);
    }


    private int getCount(BSTNode<T> node) {
        if (node == null) return 0;
        int count = getCount(node.LeftChild) + getCount(node.RightChild);
        return count + 1;
    }


    private List<BSTNode<T>> GetAllNodes()
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        List<BSTNode<T>> resultList = new ArrayList<>();
        getAllNodes(Root, resultList);
        return resultList;
    }

    private void getAllNodes(BSTNode<T> node, List<BSTNode<T>> resultList)
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        if (node == null) {
            return;
        }
        resultList.add(node);
        if (node.LeftChild == null && node.RightChild == null) {
            return;
        }
        getAllNodes(node.LeftChild, resultList);
        getAllNodes(node.RightChild, resultList);
    }

}
