package structs;

public interface Queue<T> {

    boolean insert(T value);

    T remove();

    T peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
