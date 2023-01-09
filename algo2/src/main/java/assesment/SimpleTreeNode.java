

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        // ваш код добавления нового дочернего узла существующему ParentNode
        if (ParentNode == null) {
            return;
        }
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<>();
        }
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        // ваш код удаления существующего узла NodeToDelete
        if (NodeToDelete != null && NodeToDelete.Parent != null) {
            NodeToDelete.Parent.Children.remove(NodeToDelete);
            NodeToDelete.Parent = null;
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        List<SimpleTreeNode<T>> resultList = new ArrayList<>();
        getAllNodes(this.Root, resultList);
        return resultList;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        // ваш код поиска узлов по значению
        List<SimpleTreeNode<T>> allNodes = GetAllNodes();
        return allNodes.stream()
                .filter(node -> node.NodeValue.equals(val))
                .collect(Collectors.toList());
    }



    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
        if (OriginalNode == null || NewParent == null) {
            return;
        }
        OriginalNode.Parent.Children.remove(OriginalNode);
        OriginalNode.Parent = NewParent;
        if (NewParent.Children == null) {
            NewParent.Children = new ArrayList<>();
        }
        NewParent.Children.add(OriginalNode);
    }

    public int Count()
    {
        return GetAllNodes().size();
    }

    public int LeafCount()
    {
        // количество листьев в дереве
        List<SimpleTreeNode<T>> list = GetAllNodes();
        return (int) list.stream().filter(node -> node.Children == null || node.Children.size() == 0).count();
    }

    private void getAllNodes(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> resultList)
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        if (node == null) {
            return;
        }
        resultList.add(node);
        if (node.Children == null || node.Children.isEmpty()) {
            return;
        }
        for (SimpleTreeNode<T> child : node.Children) {
            getAllNodes(child, resultList);
        }
    }
}