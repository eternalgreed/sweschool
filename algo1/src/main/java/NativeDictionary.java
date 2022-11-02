import java.lang.reflect.Array;

public class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    private static final int STEP = 1;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        // всегда возвращает корректный индекс слота
        return key.length() % size;
    }

    public boolean isKey(String key)
    {
        // возвращает true если ключ имеется,
        // иначе false
        int hash = hashFun(key);
        for (int i = 0; i < size; i++) {
            if (slots[hash] != null && slots[hash].equals(key)) {
                return true;
            } else {
                hash = (hash + STEP) % size;
            }
        }
        return false;
    }

    public void put(String key, T value)
    {
        // гарантированно записываем
        // значение value по ключу key
        int hash = hashFun(key);
        for (int i = 0; i < size; i++) {
            if (slots[hash] == null || slots[hash].equals(key)) {
                slots[hash] = key;
                values[hash] = value;
                break;
            } else {
                hash = (hash + STEP) % size;
            }
        }
    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден
        if (isKey(key)) {
            int hash = hashFun(key);
            for (int i = 0; i < size; i++) {
                if (slots[hash].equals(key)) {
                    return values[hash];
                } else {
                    hash = (hash + STEP) % size;
                }
            }
        }
        return null;
    }
}
