package strategy;

public interface SortStrategy<T extends Comparable<T>> {

    long sort(T[] objects);
}
