import java.lang.reflect.Array;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public static final int DEFAULT_CAPACITY = 16;
    private static final double INCREASING_MULTIPLIER = 2.0;
    private static final double DECREASING_MULTIPLIER = 1.5;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public void makeArray(int new_capacity) {
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);
        // ваш код
        if (new_capacity <= DEFAULT_CAPACITY) {
            new_capacity = DEFAULT_CAPACITY;
        }
        if (this.array == null) {
            this.array = (T[]) Array.newInstance(this.clazz, new_capacity);
        } else {
            T[] array = (T[]) Array.newInstance(this.clazz, new_capacity);
            System.arraycopy(this.array, 0, array, 0, count);
            this.array = array;

        }
        capacity = new_capacity;
    }


    public T getItem(int index) {
        if (index>= count || index <0) {
            throw new IllegalArgumentException();
        }
        return array[index];
    }

    public void append(T itm) {
        // ваш код
        if (capacity > count) {
            array[count++] = itm;
        } else {
            makeArray((int) (capacity * INCREASING_MULTIPLIER));
            array[count++] = itm;
        }
    }

    public void insert(T itm, int index) {
        // ваш код
        if (index < 0 || index > this.count) {
            throw new IllegalArgumentException();
        }
        if (index == count) {
            append(itm);
            return;
        }
        if (capacity < count + 1) {
            makeArray(capacity << 1);
        }
        if (count - index >= 0) {
            System.arraycopy(array, index, array, index + 1, count - index);
        }
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        if (index < 0 || index > this.count - 1) {
            throw new IllegalArgumentException();
        }
        System.arraycopy(array, index + 1, array, index, count - index - 1);
        count--;
        if (count < capacity / 2) {
            makeArray(Math.max((capacity * 2) / 3, 16));
        }
    }

}
