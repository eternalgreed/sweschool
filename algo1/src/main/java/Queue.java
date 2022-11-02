import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

    private final List<T> queue;


    public Queue() {
        // инициализация внутреннего хранилища очереди
        queue = new ArrayList<>();
    }

    public void enqueue(T item) {
        // вставка в хвост
        queue.add(item);
    }

    public T dequeue() {
        // выдача из головы
        if (queue.isEmpty()) {
            return null;
        }
        T elem = queue.get(0);
        queue.remove(0);
        return elem; // null если очередь пустая
    }

    public int size() {
        return queue.size(); // размер очереди
    }

}