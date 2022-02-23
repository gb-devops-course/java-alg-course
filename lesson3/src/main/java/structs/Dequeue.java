package structs;

public class Dequeue<T> implements Queue<T> {

    private final Object[] data;

    private int size = 0;
    private int head = 0;
    private int tail = -1;

    public Dequeue(int capacity) {
        this.data = new Object[capacity];
    }

    @Override
    public boolean insert(T value) {
        if (isFull()) {
            return false;
        }

        tail = nextIndex(tail);
        data[tail] = value;
        size++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T value = (T) data[head];
        data[head] = null;
        size--;
        head = nextIndex(head);
        return value;
    }

    @Override
    public T peekFront() {
        return (T) data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = head; i <= tail; i++) {
            sb.append(data[i]);
            if (i != tail) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    /**
     * @apiNote For test purposes only!
     * @return head value
     */
    int getHead() {
        return head;
    }

    /**
     * @apiNote For test purposes only!
     * @return tail value
     */
    int getTail() {
        return tail;
    }

    private int nextIndex(int index) {
        if (index == data.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }
}
