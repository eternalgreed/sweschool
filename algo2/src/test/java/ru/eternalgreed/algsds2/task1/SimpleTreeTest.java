package ru.eternalgreed.algsds2.task1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeTest {

    @Test
    public void addChild() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> child4 = new SimpleTreeNode<>(4, tree.Root);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<>(3, child4);
        SimpleTreeNode<Integer> child6 = new SimpleTreeNode<>(6, child4);
        tree.AddChild(tree.Root, child4);
        tree.AddChild(child4, child3);
        tree.AddChild(child4, child6);

        assertEquals(9, (int) tree.Root.NodeValue);
        assertEquals(1, tree.Root.Children.size());
        assertEquals(2, child4.Children.size());
        System.out.println(child4.Children);
    }

    //@Test
    public void deleteNode() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> child4 = new SimpleTreeNode<>(4, tree.Root);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<>(3, child4);
        SimpleTreeNode<Integer> child6 = new SimpleTreeNode<>(6, child4);
        tree.AddChild(tree.Root, child4);
        tree.AddChild(child4, child3);
        tree.AddChild(child4, child6);
        tree.DeleteNode(child4);

        assertEquals(9, (int) tree.Root.NodeValue);
        assertEquals(2, tree.Root.Children.size());
        assertEquals(0, child4.Children.size());
        assertNull(child4.Parent);
        assertNull(child4.NodeValue);
        System.out.println(tree.Root.Children);
    }

    @Test
    public void deleteNode1() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(17, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(3, root);
        tree.AddChild(root,node1);
        tree.AddChild(root, node2);
        tree.AddChild(node1,node3);
        tree.DeleteNode(node1);
        assertEquals(tree.GetAllNodes().size(),2);
        assertEquals(root.Children.get(0).NodeValue, node2.NodeValue);
    }

    @Test
    public void getAllNodes1() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        tree.AddChild(root, node1);
        assertEquals(2, tree.GetAllNodes().size());
    }


   /* @Test
    public void moveNode() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
        int [] i = {9,17,5,4,3,6,};
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(17, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(3, root);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(6, root);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(5, node1);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(node1, node3);
        tree.AddChild(node1, node4);
        tree.AddChild(node2, node5);
        tree.MoveNode(node1, node5);
        boolean check = true;
        tree.GetAllNodes();
        System.out.println(tree.nodes.size());
        for (int j = 0; j < tree.nodes.size(); j++){
            if (i[j] != tree.nodes.get(j).NodeValue){
                check = false;
            }
        }
        assertTrue(check);
    }*/

    @Test
    public void deleteNode2() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> child4 = new SimpleTreeNode<>(4, tree.Root);
        SimpleTreeNode<Integer> child17 = new SimpleTreeNode<>(17, tree.Root);
        SimpleTreeNode<Integer> child22 = new SimpleTreeNode<>(22, child17);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<>(3, child4);
        SimpleTreeNode<Integer> child6 = new SimpleTreeNode<>(6, child4);
        SimpleTreeNode<Integer> child5 = new SimpleTreeNode<>(5, child6);
        SimpleTreeNode<Integer> child7 = new SimpleTreeNode<>(7, child6);
        SimpleTreeNode<Integer> child20 = new SimpleTreeNode<>(20, child22);
        tree.AddChild(tree.Root, child4);
        tree.AddChild(tree.Root, child17);
        tree.AddChild(child17, child22);
        tree.AddChild(child4, child3);
        tree.AddChild(child4, child6);
        tree.AddChild(child6, child5);
        tree.AddChild(child6, child7);
        tree.AddChild(child22, child20);
        tree.DeleteNode(child6);

        List<SimpleTreeNode<Integer>> list= tree.GetAllNodes();

        for (SimpleTreeNode<Integer> s : list) {
            System.out.println(s.NodeValue);
        }
    }
    @Test
    public void deleteNode3() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> child4 = new SimpleTreeNode<>(4, tree.Root);
        SimpleTreeNode<Integer> child17 = new SimpleTreeNode<>(17, tree.Root);
        SimpleTreeNode<Integer> child22 = new SimpleTreeNode<>(22, child17);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<>(3, child4);
        SimpleTreeNode<Integer> child6 = new SimpleTreeNode<>(6, child4);
        SimpleTreeNode<Integer> child5 = new SimpleTreeNode<>(5, child6);
        SimpleTreeNode<Integer> child7 = new SimpleTreeNode<>(7, child6);
        SimpleTreeNode<Integer> child20 = new SimpleTreeNode<>(20, child22);
        tree.AddChild(tree.Root, child4);
        tree.AddChild(tree.Root, child17);
        tree.AddChild(child17, child22);
        tree.AddChild(child4, child3);
        tree.AddChild(child4, child6);
        tree.AddChild(child6, child5);
        tree.AddChild(child6, child7);
        tree.AddChild(child22, child20);

        List<SimpleTreeNode<Integer>> list= tree.GetAllNodes();

        for (SimpleTreeNode<Integer> s : list) {
            System.out.println(s.NodeValue);
        }
    }

    @Test
    public void getAllNodes() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> child4 = new SimpleTreeNode<>(4, tree.Root);
        SimpleTreeNode<Integer> child17 = new SimpleTreeNode<>(17, tree.Root);
        SimpleTreeNode<Integer> child22 = new SimpleTreeNode<>(22, child17);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<>(3, child4);
        SimpleTreeNode<Integer> child6 = new SimpleTreeNode<>(6, child4);
        SimpleTreeNode<Integer> child5 = new SimpleTreeNode<>(5, child6);
        SimpleTreeNode<Integer> child7 = new SimpleTreeNode<>(7, child6);
        SimpleTreeNode<Integer> child20 = new SimpleTreeNode<>(20, child22);
        tree.AddChild(tree.Root, child4);
        tree.AddChild(tree.Root, child17);
        tree.AddChild(child17, child22);
        tree.AddChild(child4, child3);
        tree.AddChild(child4, child6);
        tree.AddChild(child6, child5);
        tree.AddChild(child6, child7);
        tree.AddChild(child22, child20);

        List<SimpleTreeNode<Integer>> list= tree.GetAllNodes();

        for (SimpleTreeNode<Integer> s : list) {
            System.out.println(s.NodeValue);
        }
    }

    @Test
    public void getAllNodesByValue() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> child4 = new SimpleTreeNode<>(4, tree.Root);
        SimpleTreeNode<Integer> child17 = new SimpleTreeNode<>(17, tree.Root);
        SimpleTreeNode<Integer> child22 = new SimpleTreeNode<>(22, child17);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<>(3, child4);
        SimpleTreeNode<Integer> child6 = new SimpleTreeNode<>(6, child4);
        SimpleTreeNode<Integer> child5 = new SimpleTreeNode<>(5, child6);
        SimpleTreeNode<Integer> child7 = new SimpleTreeNode<>(7, child6);
        SimpleTreeNode<Integer> child20 = new SimpleTreeNode<>(20, child22);
        SimpleTreeNode<Integer> child20New = new SimpleTreeNode<>(20, child22);
        tree.AddChild(tree.Root, child4);
        tree.AddChild(tree.Root, child17);
        tree.AddChild(child17, child22);
        tree.AddChild(child4, child3);
        tree.AddChild(child4, child6);
        tree.AddChild(child6, child5);
        tree.AddChild(child6, child7);
        tree.AddChild(child22, child20);
        tree.AddChild(child22, child20New);

        System.out.println("EQUALS? " + child20.equals(child20New));




        List<SimpleTreeNode<Integer>> simpleTreeNodes = tree.FindNodesByValue(20);

        for (SimpleTreeNode<Integer> s : simpleTreeNodes) {
            System.out.println(s.NodeValue);
        }
    }


    @Test
    public void testSimpleTree(){
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4, null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5, null);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<Integer>(6, null);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<Integer>(7, null);

        SimpleTree<Integer> myTree = new SimpleTree<Integer>(node1);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
        System.out.println("0: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());

        myTree.AddChild(null, node2);

        System.out.println("1: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.AddChild(node1, node2);
        myTree.AddChild(node1, node3);
//        myTree.AddChild(null, node2);
//        myTree.AddChild(node2, null);

        System.out.println("2: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.AddChild(node2, node4);
        myTree.AddChild(node2, node5);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
        System.out.println("3: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.DeleteNode(node2);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }

        System.out.println("3.1: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.AddChild(node1, node2);
        myTree.AddChild(node2, node4);
        myTree.AddChild(node2, node5);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
        System.out.println("4: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());

        myTree.AddChild(node3, node6);
        myTree.AddChild(node3, node7);
        System.out.println("5: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());

        myTree.DeleteNode(myTree.Root);
        System.out.println("6: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
    }


    @Test
    public void leafCount() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(9, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(4, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(3, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(6, root);
        tree.AddChild(root, node1);
        assertEquals(1, tree.LeafCount());
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(5, root);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(7, root);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<>(17, root);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<>(22, root);
        SimpleTreeNode<Integer> node8 = new SimpleTreeNode<>(20, root);
        tree.AddChild(root, node6);
        tree.AddChild(node1,node2);
        tree.AddChild(node1,node3);
        tree.AddChild(node3,node4);
        tree.AddChild(node3,node5);
        tree.AddChild(node6,node7);
        tree.AddChild(node7,node8);
        assertEquals(4,tree.LeafCount());

    }



    @Test
    void findNodesByValue() {
    }

    @Test
    void moveNode1() {
    }

    @Test
    void count() {
    }

}