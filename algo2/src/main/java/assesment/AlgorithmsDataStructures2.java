
import java.util.*;

public class AlgorithmsDataStructures2
{
    public static int[] GenerateBBSTArray(int[] a)
    {
        Arrays.sort(a);
        int depth = 0;
        int balancedTreeSize =1;
        while (balancedTreeSize<=a.length){
            balancedTreeSize *= 2;
            depth++;
        }
        balancedTreeSize--;
        int [] resultArr = new int[balancedTreeSize];
        generateBBSTArrayRec(a, resultArr,0, a.length, 0);
        return resultArr;
    }

    private static void generateBBSTArrayRec(int[] a, int[] result, int start, int end, int treeIndex) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start)/2;
        result[treeIndex] = a[middle];
        int leftChildIndex = 2* treeIndex +1;
        int rightChildIndex = 2* treeIndex +2;
        if (leftChildIndex < result.length) {
            generateBBSTArrayRec(a, result, start, middle, leftChildIndex);
        }
        if (rightChildIndex < result.length) {
            generateBBSTArrayRec(a, result, middle, end,rightChildIndex);
        }
    }
}