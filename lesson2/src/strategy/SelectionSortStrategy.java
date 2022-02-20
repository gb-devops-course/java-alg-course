package strategy;

public class SelectionSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public long sort(T[] objects) {
        var iterationsCount = 0;

        for (int i = 0; i < objects.length; i++) {
            int min = i;

            for (int j = i + 1; j < objects.length; j++) {
                if (objects[j].compareTo(objects[min]) < 0) {
                    min = j;
                }
                iterationsCount++;
            }

            T temp = objects[i];
            objects[i] = objects[min];
            objects[min] = temp;
        }

        return iterationsCount;
    }
}
