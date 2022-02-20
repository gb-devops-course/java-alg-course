package strategy;

public class InsertionSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public long sort(T[] objects) {
        var iterationsCount = 0;

        for (int i = 0; i < objects.length; i++) {
            int j = i - 1;
            T value = objects[i];

            while (j >= 0 && objects[j].compareTo(value) > 0) {
                iterationsCount++;
                objects[j+1] = objects[j];
                j--;
            }

            objects[j+1] = value;
        }

        return iterationsCount;
    }
}
