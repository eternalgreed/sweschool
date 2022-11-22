/**
 *
 * 1) void sendMailsFromBuffer(List<Mail> buffer) - void sendMailsAndResetBuffer(List<Mail> buffer)
 *  // метод который отправляет имейлы из буфера и сбрасывает этот буфер, в первом случае метод не отражал всей логики
 *
 * 2) public boolean isValue(String str1) - public boolean containsString(String str1)
 *  // проверка, имеется ли строка str1 в фильтре
 *
 * 3) public void add(String str1) - public void addString(String str1)
 *  // метод добавляет строку в фильтр Блюма
 *
 * 4) public PowerSet difference(PowerSet set2) - public PowerSet getDifference(PowerSet set2)
 * // метод возвращает разницу текущего множества и множества-параметра
 *
 * 5) public PaymentData getDataToSave(HttpRequest rq) - public PaymentData formDataFromHttpRequest(HttpRequest rq)
 * // сформировать из запроса данные о платеже
 *
 * 6) public PowerSet union(PowerSet set2) - public PowerSet getUnion(PowerSet set2)
 * // метод возвращает объединение текущего множества и множества-параметра
 *
 * 7) public PowerSet union intersection(PowerSet set2) - public PowerSet getIntersection(PowerSet set2)
 * // метод возвращает пересечение текущего множества и множества-параметра
 *
 * 8) public static LinkedList addTwoLL(LinkedList first, LinkedList second) - public static LinkedList getSumsListIfEqualLengths (LinkedList first, LinkedList second)
 * // метод возвращает список, каждый элемент которого равен сумме соответствующих входных списков, если их длины равны
 *
 * 9) public void rotate(int radians) - public rotateInRadians(int radians)
 *  //Метод класса Rectangle Для поворота на N радиан
 *
 * 10) public boolean isValue(String str1) - public boolean containsString(String str1)
 * // метод проверяет, содержится ли строка в фильтре Блюма
 *
 * 11) sendToKafka(String json) - sendToKafkaIfNotEmpty(String json)
 * // отправить сообщение в кафку только в тому случае если оно не пустое
 *
 * 12) public BigDecimal calculateCommission(PaymentControllerRq rq) - public BigDecimal calculateReceiverCommission(PaymentController rq)
 * // рассчитать комиссию Получателя
 *
 */

public class Method_Names_1 {
}
