public class BloomFilter
{
    public int filter_len;
    public int filter;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        filter = 0;
        // создаём битовый массив длиной f_len ...
    }

    // хэш-функции
    public int hash1(String str1)
    {
        // 17
        int hash = 0;
        int magicNumber = 17;
        for(int i=0; i<str1.length(); i++)
        {
            hash *= magicNumber;
            int code = (int)str1.charAt(i);
            hash += code;
            hash %= filter_len;
        }
        // реализация ...
        return 1 << hash;
    }
    public int hash2(String str1)
    {
        // 223
        // реализация ...
        int hash = 0;
        int magicNumber = 223;
        for(int i=0; i<str1.length(); i++)
        {
            hash *= magicNumber;
            int code = (int)str1.charAt(i);
            hash += code;
            hash %= filter_len;
        }
        // реализация ...
        return 1 << hash;
    }

    public void add(String str1)
    {
        // добавляем строку str1 в фильтр
        filter |= hash1(str1) | hash2(str1);
    }

    public boolean isValue(String str1)
    {
        // проверка, имеется ли строка str1 в фильтре
        int mask = hash1(str1) | hash2(str1);
        return (filter & mask) == mask;
    }
}
