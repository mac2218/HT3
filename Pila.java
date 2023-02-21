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

public class PilaVector<T> extends Pila<T> {
    private Vector<T> elementos;

    public PilaVector() {
        elementos = new Vector<T>();
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

public abstract class Lista<T> {
    public abstract void insertarInicio(T elemento);
    public abstract void insertarFinal(T elemento);
    public abstract T eliminarInicio();
    public abstract T eliminarFinal();
    public abstract T obtenerInicio();
    public abstract T obtenerFinal();
    public abstract boolean estaVacia();
}

public class ListaSimplementeEncadenada<T> extends Lista<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;

    private static class Nodo<T> {
        T elemento;
        Nodo<T> siguiente;

        Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    public void insertarInicio(T elemento) {
        Nodo<T> nodo = new Nodo<T>(elemento);
        if (estaVacia()) {
            inicio = nodo;
            fin = nodo;
        } else {
            nodo.siguiente = inicio;
            inicio = nodo;
        }
    }

    public void insertarFinal(T elemento) {
        Nodo<T> nodo = new Nodo<T>(elemento);
        if (estaVacia()) {
            inicio = nodo;
            fin = nodo;
        } else {
            fin.siguiente = nodo;
            fin = nodo;
        }
    }
    
    public T eliminarInicio() {
        if (estaVacia()) {
            return null;
        }
        T elemento = inicio.elemento;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.siguiente;
        }
        return elemento;
    }

    public T eliminarFinal() {
        if (estaVacia()) {
            return null;
        }
        T elemento = fin.elemento;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            Nodo<T> actual = inicio;
            while (actual.siguiente != fin) {
                actual = actual.siguiente;
            }
            fin = actual;
            fin.siguiente = null;
        }
        return elemento;
    }

    public T obtenerInicio() {
        if (estaVacia()) {
            return null;
        }
        return inicio.elemento;
    }

    public T obtenerFinal()}
       

    