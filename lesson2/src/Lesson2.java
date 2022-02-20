import strategy.CombSortStrategy;
import strategy.InsertionSortStrategy;
import strategy.SelectionSortStrategy;
import utility.Sorter;
import utility.NotebooksGenerator;

public class Lesson2 {

    private static final int NOTEBOOKS_COUNT = 10000;

    public static void main(String[] args) {
        var notebooks = NotebooksGenerator.generateNotebooksArray(NOTEBOOKS_COUNT);

        var combNotebooks = notebooks.clone();
        System.out.printf("Comb sort: %s%n", Sorter.sort(combNotebooks, new CombSortStrategy<>()));

        var insertionNotebooks = notebooks.clone();
        System.out.printf("Insertion sort: %s%n", Sorter.sort(insertionNotebooks, new InsertionSortStrategy<>()));

        var selectionNotebooks = notebooks.clone();
        System.out.printf("Selection sort: %s%n", Sorter.sort(selectionNotebooks, new SelectionSortStrategy<>()));

        // Сортировка выбором работает довольно быстро
        // Сортировка вставками работает еще быстрее
        // Лучшее время тут показала сортировка "расческой"

        // Comb sort: duration=11, iterations=339643
        // Insertion sort: duration=103, iterations=24969348
        // Selection sort: duration=135, iterations=49995000
    }
}
