import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private final List<T> stack;

    public Stack() {
        // инициализация внутреннего хранилища стека
        stack = new ArrayList<>();
    }

    public int size() {
        // размер текущего стека
        return stack.size();
    }

    public T pop() {
        // ваш код
        if (stack.isEmpty()) return null;
        T poppedElem = stack.get(0);
        stack.remove(0);
        return poppedElem;
    }

    public void push(T val) {
        // ваш код
        stack.add(0, val);
    }

    public T peek() {
        // ваш код
        return stack.isEmpty() ? null : stack.get(0);
    }
}