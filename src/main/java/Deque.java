import java.util.*;

public class Deque<T>
{
    private ArrayList<T> deque;

    public Deque() {
        this.deque = new ArrayList<>();
        // инициализация внутреннего хранилища
    }

    public void addFront(T item) {
        this.deque.add(0, item);
        // добавление в голову
    }

    public void addTail(T item) {
        this.deque.add(item);
        // добавление в хвост
    }

    public T removeFront() {
        if (this.deque.size() > 0) {
            T current = this.deque.get(0);
            this.deque.remove(0);
            return current;
        }
        // удаление из головы
        return null;
    }

    public T removeTail() {
        // удаление из хвоста
        if (this.deque.size() > 0) {
            T current = this.deque.get(this.deque.size()-1);
            this.deque.remove(this.deque.size()-1);
            return current;
        }
        return null;
    }

    public int size() {
        return this.deque.size(); // размер очереди
    }
}
