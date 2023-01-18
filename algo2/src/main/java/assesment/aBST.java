import java.util.*;

class aBST
{
    public Integer Tree []; // массив ключей

    public aBST(int depth)
    {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int) (Math.pow(2, depth + 1) - 1);
        Tree = new Integer[ tree_size ];
        for(int i=0; i<tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key)
    {
        // ищем в массиве индекс ключа
        int currentIndex = 0;
        while (currentIndex <= Tree.length) {
            if (Tree[currentIndex] == null) {
                return -currentIndex;
            }
            if (Tree[currentIndex] == key) {
                return currentIndex;
            }
            if (key < Tree[currentIndex]) {
                //идем в левое поддерево
                // currentIndex = (2 * currentIndex) + 1;
                // calculateChildIndex(currentIndex, true);
                currentIndex = leftChildIndex(currentIndex);
            } else {
                //иначе правое
                // currentIndex = (2 * currentIndex) + 2;
                // calculateChildIndex(currentIndex, false);
                currentIndex = rightChildIndex(currentIndex);
            }
        }
        return null; // не найден
    }

    private int calculateChildIndex (int index, boolean isLeft) {
        if (isLeft) {
            return (2 * index) + 1;
        } else {
            return  (2 * index) + 2;
        }
    }

    private int leftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightChildIndex(int index) {
        return (2 * index) + 2;
    }

    public int AddKey(int key)
    {
        // добавляем ключ в массив
        Integer index = FindKeyIndex(key);
        if (index == null) {
            return -1;
        }
        if (index < 0) {
            index = - index;
            Tree[index] = key;
            return index;
        }
        return index;
        // индекс добавленного/существующего ключа или -1 если не удалось
    }

}