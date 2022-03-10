public interface Tree<E extends Comparable<? super E>> {

    boolean contains(E value);

    void add(E value);

    void remove(E value);

    int height();
}
