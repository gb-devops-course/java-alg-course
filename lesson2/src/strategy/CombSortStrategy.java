package strategy;

public class CombSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {

    private static final double GAP_COEFF = 1.247330950103979d;

    @Override
    public long sort(T[] objects) {
        var iterationsCount = 0;

        int gap = objects.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / GAP_COEFF);

            int i = 0;
            swapped = false;
            while (i + gap < objects.length) {
                if (objects[i].compareTo(objects[i + gap]) > 0) {
                    T t = objects[i];
                    objects[i] = objects[i + gap];
                    objects[i + gap] = t;
                    swapped = true;
                }
                iterationsCount++;
                i++;
            }
        }

        return iterationsCount;
    }
}
