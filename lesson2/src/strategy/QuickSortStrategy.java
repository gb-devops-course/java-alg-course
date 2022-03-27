package strategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {

    private int iterationsCount = 0;

    @Override
    public long sort(T[] objects) {
        var result = sort(Arrays.asList(objects));
        check(result);
        return iterationsCount;
    }

    private List<T> sort(List<T> objects) {
        if (objects.size() <= 1) {
            return objects;
        }

        iterationsCount++;
        T baseValue = objects.get(0);

        List<T> less = new LinkedList<>();
        List<T> equal = new LinkedList<>();
        List<T> more = new LinkedList<>();

        for (var item : objects) {
            if (item.compareTo(baseValue) < 0) {
                less.add(item);
            } else if (item.compareTo(baseValue) > 0) {
                more.add(item);
            } else {
                equal.add(item);
            }
        }

        less = sort(less);
        more = sort(more);

        less.addAll(equal);
        less.addAll(more);

        return less;
    }

    private void check(List<T> objects) {
        for (int i = 0; i < objects.size() - 1; i++) {
            if (objects.get(i).compareTo(objects.get(i + 1)) > 0) {
                System.out.println("Check failed!");
                return;
            }
        }

        System.out.println("Check successful!");
    }
}
