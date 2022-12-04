/**
 *
 * 1)
 * // Было:
 * step = stp;
 * // Стало:
 * final int STEP = stp;
 * // Переменная в хеш-таблице заменена константой
 *
 * 2)
 * // Было:
 * size = sz;
 * // Стало:
 * final int SIZE = sz;
 * // Переменная в хеш-таблице заменена константой
 *
 * 3)
 * // Было:
 * makeArray(16);
 * // Стало:
 * final int MIN_CAPACITY = 16;
 * makeArray(MIN_CAPACITY);
 * // В динамическом массиве добавлена константа, хранящая минимальный размер массива
 *
 *
 * 4)
 * // Было:
 * filter_len = f_len;
 * // Стало:
 * final int FILTER_LENGTH = f_len;
 * // Переменная в фильтре Блюма заменена константой
 *
 *
 * 5)
 * // Было:
 * for (int i = 0; i < str1.length(); i++) {
 *     int code = (int) str1.charAt(i);
 *     hash = (hash * 17 + code) % filter_len;
 * }
 * // Стало:
 * int code = 0
 * for (int i = 0; i < str1.length(); i++) {
 *     code = (int) str1.charAt(i);
 *     hash = (hash * RND_NUMBER + code) % FILTER_LENGTH;
 * }
 * // В фильтре Блюма переменная code инициализирована перед циклом
 *
 * 6)
 * // Было:
 * int i = HeapSize - 1;
 * HeapArray[0] = HeapArray[i];
 * HeapArray[i] = 0;
 * i = 0;
 * while (true) {
 *     int max = i;
 *     ...
 *     i = max;
 * }
 * // Стало:
 * HeapArray[0] = HeapArray[HeapSize - 1];
 * HeapArray[HeapSize - 1] = 0;
 * int i = 0;
 * int max = 0;
 * while (true) {
 *     max = i;
 *     ...
 *     i = max;
 * }
 * // Переменная i теперь используется только в теле цикла, переменная max инициализирована перед циклом
 *
 *
 * 7)
 * // Было:
 * max_vertex = size;
 * // Стало:
 * final int MAX_VERTICES_NUM = f_len;
 * // Переменная, обозначающая максимальное число вершин в графе, заменена константой
 *
 * // Было:
 * while (!stack.empty()) {
 *     int x = Arrays.asList(vertex).indexOf(stack.peek());
 *     ...
 * }
 * // Стало:
 * int x = 0;
 * while (!stack.empty()) {
 *     x = Arrays.asList(vertex).indexOf(stack.peek());
 *     ...
 * }
 *
 * 8)
 * StringBuilder result = new StringBuilder();
 * if (fixedPhone.length() < PHONE_LENGTH) {
 *      result.append(PHONE_START_WITH_7).append(fixedPhone);
 * } else if (fixedPhone.length() == PHONE_LENGTH) {
 *      if (!fixedPhone.startsWith(PHONE_START_WITH_7)) {
 *          result.append(PHONE_START_WITH_7).append(fixedPhone.substring(1));
 *}     else { result.append(fixedPhone); }
 *  } else {
 *        result.append(fixedPhone);
 * }
 * // result перенесен к месту первого применения
 *
 * 9)
 * String body = null;
 * if (feignException.responseBody().isPresent()) {
 *      body = feignException.contentUTF8();
 * }
 * // body перенесен к месту первого применения
 *
 *
 * 10)
 * final UUID id = userService.getUserData(unc).getId();
 * try {
 *   auditLogService.logAcceptAgreement(unc, id, EventClass.SUCCESS);
 * } catch (Exception e) {
 *   auditLogService.logAcceptAgreement(unc, id, EventClass.FAILURE);
 *   throw e;
 * } // id перенесен к месту первого применения, сделан final
 *
 *=================================================================
 * Новых примеров больше не нашел, было парочку с инициализацией далеко от использования, но это было бы слишком много однотипных, так что всего набралось 10 :(
 *
 *
 *
 *
 */


public class Variables_And_Values_1 {
}
