/**
 * 6.
 * 1)
 * return value.getBytes().length % size;
 * if (size > 0) {return value.getBytes().length % size}
 * // добавлена проверка, что хэш-таблица не пустая
 *
 * 2)
 * hash = (hash * 17 + code) % filter_len;
 * if {filter_len > 0) {hash = (hash * 17 + code) % filter_len}
 * // добавлена проверка, что фильтр Блюма не пустой
 *
 * 3)
 * boolean outOfBounds = index < 0 && index > capacity;
 * // в динамическом массиве условие заменено логической переменной
 *
 * 4)
 * boolean  containsValue = slots[slot] != null && slots[slot].equals(value);
 * // в методах get множества условие заменено логической переменной
 *
 *
 * 5)
 * boolean containsKey = slots[slot].equals(key);
 * // для упрощения условий в методах put и get кэша использована логическая переменная
 *
 *
 * 6)
 * boolean outOfBounds = pointer > array[array.length - 1] || pointer < array[0];
 * // упрощено условие выхода за границы массива
 *
 * 7)
 * boolean firstValueIsInteger = v1.getClass() == Integer.class
 * // для упрощения условий в упорядоченном списке использованы логические переменные
 *
 * 8)
 * boolean secondValueIsString = v2.getClass() == String.class
 * // для упрощения условий в упорядоченном списке использованы логические переменные
 *
 * 9)
 * boolean isEmpty = email == null || "".equals(email);
 * // двойное условие на проверку пустоты строки вынесено в отдельную булеву переменную
 *
 *
 * 10)
 * if ((receiver != null && receiver.isActive()) || (sender != null && sender.isActive()))
 * boolean isActiveSender = sender != null && sender.isActive()
 * boolean isActiveReceiver = receiver != null && receiver.isActive()
 * if (isActiveSender || isActiveReceiver)...
 * // добавил логические переменные
 *
 *
 * 11)
 * "UTC-5" заменил на private static String NY_TIME_ZONE = "UTC-5"
 *
 *
 * 12)
 * "_" магическую строку заменил на константу private static String DEFAULT_STRING_DELIMITER = "_"
 *
 *
 */
public class Data_Types_1 {
    public static void main(String[] args) {
    }
}
