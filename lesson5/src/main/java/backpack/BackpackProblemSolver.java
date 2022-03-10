package backpack;

import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// L - 500 / 3kg
// C - 30 / 1kg
// A - 10 / 1kg
// G - 10 / 3kg
// S - 70 / 2kg
// max - 5kg
public class BackpackProblemSolver {

    private static final int MAX_WEIGHT = 5;

    private final List<BackpackItem> items = new ArrayList<>() {{
        add(new BackpackItem(500L, 3));
        add(new BackpackItem(30L, 1));
        add(new BackpackItem(10L, 1));
        add(new BackpackItem(10L, 3));
        add(new BackpackItem(70L, 2));
    }};

    private final Set<Backpack> resultSet = new HashSet<>();

    public static void main(String[] args) {
        var backpackProblemSolver = new BackpackProblemSolver();
        backpackProblemSolver.solve();
    }

    public void solve() {
        find(items, 0);

        var backpack = resultSet.stream()
                .max(Comparator.comparing(Backpack::getPrice))
                .orElseThrow();
        System.out.println(backpack);
    }

    private void find(List<BackpackItem> list, int startIndex) {
        if (list.size() <= 1) {
            return;
        }

        var subList= list.subList(startIndex, list.size());
        for (int i = 0; i < subList.size(); i++) {
            var listToChange = new ArrayList<>(subList);
            Collections.swap(listToChange, 0, i);
            find(listToChange, 1);

            int weight = list.stream().map(it -> it.weight).reduce(0, Integer::sum);
            if (weight <= MAX_WEIGHT) {
                resultSet.add(Backpack.builder()
                        .items(list)
                        .price(list.stream().map(it -> it.price).reduce(0L, Long::sum))
                        .weight(weight)
                        .build());
            }
        }
    }

    @Value
    @Builder
    private static class Backpack {
        List<BackpackItem> items;
        long price;
        int weight;
    }

    @Value
    private static class BackpackItem {
        long price;
        int weight;
    }
}
