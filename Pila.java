public abstract class Pila<T> {
    public abstract void push(T elemento);
    public abstract T pop();
    public abstract T peek();
    public abstract boolean isEmpty();
}

public class PilaArrayList<T> extends Pila<T> {
    private ArrayList<T> elementos;

    public PilaArrayList() {
        elementos = new ArrayList<T>();
    }

    public void push(T elemento) {
        elementos.add(elemento);
    }

    public T pop() {
        return elementos.remove(elementos.size() - 1);
    }

    public T peek() {
        return elementos.get(elementos.size() - 1);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
