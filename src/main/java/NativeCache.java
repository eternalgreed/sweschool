class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    int step;

    public NativeCache(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(clazz, size);
        step = 3;
    }

    public int hashFun(String key) {
        return key.getBytes().length % size;
    }

    public boolean isKey(String key) {

        return get(key) != null;
    }

    public void put(String key, T value) {
        int slot = hashFun(key);
        for (int i = 0; i < size; i++) {
            if (slots[slot] == null || slots[slot].equals(key)) {
                hits[slot]=0;
                slots[slot] = key;
                values[slot] = value;
                return;
            }
            slot = slot + step;
            if (slot >= size) {
                slot = slot - size;
            }
        }
        int min = hits[0];
        int minIndex = 0;
        for (int i = 0; i < hits.length; i++) {
            if (hits[i] < min) {
                min = hits[i];
                minIndex = i;
            }
        }
        hits[minIndex] = 0;
        slots[minIndex] = key;
        values[minIndex] = value;
    }


    public T get(String key) {
        int slot = hashFun(key);

        for (int i = 0; i < size; i++) {
            if (slots[slot] != null && slots[slot].equals(key)) {
                hits[slot]++;
                return values[slot];
            }
            slot = slot + step;
            if (slot >= size) {
                slot = slot - size;
            }
        }
        return null;
    }

}
