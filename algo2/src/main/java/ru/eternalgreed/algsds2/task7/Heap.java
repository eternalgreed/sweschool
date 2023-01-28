package ru.eternalgreed.algsds2.task7;

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи

    public int size = 0;

    public Heap() { HeapArray = null; }

    public void MakeHeap(int[] a, int depth)
    {
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        // ...
        int heapSize =(int) Math.pow(2, depth + 1) - 1;
        HeapArray = new int[heapSize];
        for (int element: a) {
            Add(element);
        }
    }


    public int GetMax()
    {
        // вернуть значение корня и перестроить кучу
        if (size <= 0) {
            return -1; // если куча пуста
        }
        int rootElem = HeapArray[0];
        int lastElem = HeapArray[size -1];
        HeapArray[0] = lastElem;
        HeapArray[size - 1] = 0;
        siftDown(0);
        size--;
        return rootElem;
    }

    private void siftDown(int parentIndex) {
        int firstChildIndex = 2 * parentIndex + 1;
        int secondChildIndex = 2 * parentIndex + 2;
        int maxChildIndex =  HeapArray[firstChildIndex] > HeapArray[secondChildIndex] ? firstChildIndex : secondChildIndex;
        if (HeapArray[parentIndex] >= HeapArray[maxChildIndex]) {
            return;
        }
        swap(HeapArray, parentIndex, maxChildIndex);
        siftDown(maxChildIndex);
    }

    public boolean Add(int key)
    {
        // добавляем новый элемент key в кучу и перестраиваем её
        if (size >= HeapArray.length) {
            return false;
        }
        HeapArray[size] = key;
        siftUp(size);
        size++;
        return true; // если куча вся заполнена
    }

    public void siftUp(int index){
        int parentIndex = (index - 1) / 2;
        if(HeapArray[index] <= HeapArray[parentIndex]){
            return;
        }
        swap(HeapArray, index, parentIndex);
        siftUp(parentIndex);
    }

    private void swap(int [] heapArray, int firstIndex, int secondIndex) {
        int temp = heapArray[firstIndex];
        heapArray[firstIndex] = heapArray[secondIndex];
        heapArray[secondIndex] = temp;
    }

}