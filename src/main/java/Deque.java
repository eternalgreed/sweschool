import java.util.*;

public class Deque<T>
{
    private ArrayList<T> deque;

    public Deque() {
        this.deque = new ArrayList<>();
    }

    public void addFront(T item) {
        this.deque.add(0, item);
    }

    public void addTail(T item) {
        this.deque.add(item);
    }

    public T removeFront() {
        if (this.deque.size() > 0) {
            T current = this.deque.get(0);
            this.deque.remove(0);
            return current;
        }
        return null;
    }

    public T removeTail() {
        if (this.deque.size() > 0) {
            T current = this.deque.get(this.deque.size()-1);
            this.deque.remove(this.deque.size()-1);
            return current;
        }
        return null;
    }

    public int size() {
        return this.deque.size();
    }
}
