/**
 * 3.1
 * Так как пишу на джава при возможности пишу javadoc, не уверен что это можно назвать комментарием
 *
 * public void insert(T itm, int index) {
 *         if (index < 0 || index > this.count) {
 *             throw new IllegalArgumentException();
 *         }
 *         if (index == count) {
 *             append(itm);
 *             return;
 *         }
 *         //побитовый сдвиг заменяет умножение на 2
 *         if (capacity < count + 1) {
 *             makeArray(capacity << 1);
 *         }
 *         //копируем массив при вставке не в конец
 *         if (count - index >= 0) {
 *             System.arraycopy(array, index, array, index + 1, count - index);
 *         }
 *         array[index] = itm;
 *         count++;
 *     }
 *
 *  Честно говоря не нашел каких-то примеров в памяти где были бы по настоящему уместны комментарии, из урока вынес для себя,
 *  что в первую очередь стремимся написать самодокументируемый код не требующий комментариев, и что это последнее к чему стоит прибегать.
 *
 *
 *
 *
 *
 *
 *
 */
public class Comments_1 {
}
