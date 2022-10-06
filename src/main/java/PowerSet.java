import java.util.Hashtable;

public class PowerSet
{
    Hashtable<String, String> hashtable;

    public PowerSet()
    {
        hashtable = new Hashtable<>(20000);
        // ваша реализация хранилища
    }

    public int size()
    {
        // количество элементов в множестве
        return hashtable.size();
    }


    public void put(String value)
    {
        // всегда срабатывает
        if (!hashtable.contains(value)) {
            hashtable.put(value, value);
        }
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false

        return hashtable.contains(value);
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        if (hashtable.contains(value)) {
            return hashtable.remove(value).equals(value);
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet intersectionSet = new PowerSet();
        if (size() > set2.size()) {
            for (String value : set2.hashtable.values()) {
                if (hashtable.contains(value)) {
                    intersectionSet.put(value);
                }
            }
        } else {
            for (String value : hashtable.values()) {
                if (set2.hashtable.contains(value)) {
                    intersectionSet.put(value);
                }
            }
        }
        return intersectionSet;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        PowerSet unionSet = new PowerSet();
        for (String value : hashtable.values()) {
            if (!unionSet.get(value)) {
                unionSet.put(value);
            }
        }
        for (String value : set2.hashtable.values()) {
            if (!unionSet.get(value)) {
                unionSet.put(value);
            }
        }

        return unionSet;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        PowerSet differenceSet = new PowerSet();

        for (String value : hashtable.values()) {
                if (!set2.hashtable.contains(value)) {
                    differenceSet.put(value);
                }
        }

        return differenceSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        if (set2.size() == 0) {
            return true;
        }
        if (size() >= set2.size()) {
            boolean result;
            for (String value : set2.hashtable.values()) {
                result = hashtable.contains(value);
                if (!result) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
