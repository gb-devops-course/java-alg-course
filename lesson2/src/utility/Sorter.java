package utility;

import model.SortResult;
import strategy.SortStrategy;

public class Sorter {

    /**
     * Сортировка массива
     * @param compObjects массив объектов
     * @return время в мс потраченное на сортировку
     */
    public static <T extends Comparable<T>> SortResult sort(T[] compObjects, SortStrategy<T> strategy) {
        var before = System.currentTimeMillis();
        var iterations = strategy.sort(compObjects);
        var after = System.currentTimeMillis();
        return new SortResult(after - before, iterations);
    }
}
